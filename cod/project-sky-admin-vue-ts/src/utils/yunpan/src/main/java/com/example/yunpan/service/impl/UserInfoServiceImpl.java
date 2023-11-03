package com.example.yunpan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.yunpan.config.AppConfig;
import com.example.yunpan.entity.UserInfo;
import com.example.yunpan.entity.dto.UserInfoDto;
import com.example.yunpan.mapper.UserInfoMapper;
import com.example.yunpan.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.yunpan.util.Constants;
import com.example.yunpan.util.GlobalException;
import com.example.yunpan.util.MD5;
import com.example.yunpan.util.RandomCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author baomidou
 * @since 2023-05-29
 */
@Service
@Transactional
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {
    @Autowired
    RedisTemplate<String,Object> template;
    @Autowired
    AppConfig appConfig;
    @Autowired
    JavaMailSender javaMailSender;
    @Override
    public void sendEmail(Integer type, String email) throws GlobalException {
        LambdaQueryWrapper<UserInfo> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(!StringUtils.isEmpty(email),UserInfo::getEmail,email);
        UserInfo userInfo=getOne(wrapper);
        if(userInfo!=null&&type==0){
            throw GlobalException.build("该邮箱已被注册");
        }
        String code= RandomCode.getRandomCode(Constants.EMAIL_CODE_LENGTH);
        //发送邮件
        sendMailCode(email,code);
    }
    public void sendMailCode(String emailName,String code) throws GlobalException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try{
            MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
            mimeMessageHelper.setFrom(appConfig.getSendUserName());
            mimeMessageHelper.setTo(emailName);
            mimeMessageHelper.setSentDate(new Date());
            mimeMessageHelper.setSubject("邮箱验证码");
            mimeMessageHelper.setText("你的验证码为"+code);
            template.opsForValue().set(emailName,code,15*60*1000, TimeUnit.MILLISECONDS);
            javaMailSender.send(mimeMessage);
        }catch (Exception e){
            throw GlobalException.build("发送失败");
        }

    }
    @Override//注册
    public void register(UserInfo userInfo,String emailCode,Integer type) throws GlobalException {
        if(type==null)
        checkRegister(userInfo,emailCode);
        userInfo.setUserId(RandomCode.getRandomCode(Constants.USER_ID_LENGTH));
        //密码MD5加密
        String password=userInfo.getPassword();
        userInfo.setPassword(MD5.encrypt(password));
        userInfo.setState(Constants.NOT_DELETE);
        userInfo.setUserSpace(0L);
        userInfo.setTotalSpace(200*Constants.MB);
        save(userInfo);
    }
    public void checkRegister(UserInfo userInfo,String emailCode) throws GlobalException {//检测邮箱，昵称及邮箱验证码是否符合
        LambdaQueryWrapper<UserInfo> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(!StringUtils.isEmpty(userInfo.getEmail()),UserInfo::getEmail,userInfo.getEmail());
        if(getOne(wrapper)!=null){
            throw GlobalException.build("邮箱已存在");
        }
        wrapper.clear();
        wrapper.eq(!StringUtils.isEmpty(userInfo.getNickName()),UserInfo::getNickName,userInfo.getNickName());
        if(getOne(wrapper)!=null){
            throw GlobalException.build("昵称已存在");
        }
        String sendEmailCode=(String)template.opsForValue().get(userInfo.getEmail());
        if(StringUtils.isEmpty(sendEmailCode)){
            throw GlobalException.build("邮箱验证码已失效,请重新获取");
        }
        if(!emailCode.equals(sendEmailCode)){
            throw GlobalException.build("邮箱验证码错误");
        }
    }
    @Override//登录
    public UserInfoDto login(String email,String password) throws GlobalException {
        LambdaQueryWrapper<UserInfo> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(!StringUtils.isEmpty(email),UserInfo::getEmail,email);
        wrapper.eq(!StringUtils.isEmpty(password),UserInfo::getPassword,MD5.encrypt(password));
        UserInfo one = this.getOne(wrapper);
        if(one==null){
            throw GlobalException.build("用户名或密码错误");
        }
        String token="user:"+ UUID.randomUUID();
        template.opsForValue().set(token,one,30,TimeUnit.MINUTES);//登录时将token加入redis
        UserInfoDto userInfoDto=new UserInfoDto();
        userInfoDto.setUserId(one.getUserId());
        userInfoDto.setAvatar(one.getQqAvatar());
        userInfoDto.setNickName(one.getNickName());
        userInfoDto.setIsAdmin(appConfig.getAdminEmail().equals(one.getEmail()));
        userInfoDto.setUseSpace(one.getUserSpace());
        userInfoDto.setTotalSpace(one.getTotalSpace());
        userInfoDto.setToken(token);
        return userInfoDto;
    }
    //重置密码
    @Override
    public void updatePassword(UserInfo userInfo, String emailCode) throws GlobalException {
        String sendEmailCode=(String)template.opsForValue().get(userInfo.getEmail());
        if(StringUtils.isEmpty(sendEmailCode)){
            throw GlobalException.build("邮箱验证码已失效,请重新获取");
        }
        if(!emailCode.equals(sendEmailCode)){
            throw GlobalException.build("邮箱验证码错误");
        }
        userInfo.setPassword(MD5.encrypt(userInfo.getPassword()));
        LambdaQueryWrapper<UserInfo> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(!StringUtils.isEmpty(userInfo.getEmail()),UserInfo::getEmail,userInfo.getEmail());
        this.baseMapper.update(userInfo,wrapper);
    }
    //更新头像
    @Override
    public void updateAvatar(String id, String filePath) {
        UserInfo userInfo = this.getById(id);
        userInfo.setQqAvatar(filePath);
        this.baseMapper.updateById(userInfo);
    }
    //获取头像地址
    @Override
    public String getAvatarPath(String id) {
        UserInfo userInfo = this.getById(id);
        return userInfo.getQqAvatar();
    }

    @Override
    public void updatePasswordById(String id,String password) {
        UserInfo userInfo = this.getById(id);
        userInfo.setPassword(MD5.encrypt(password));
        this.updateById(userInfo);
    }

    @Override
    public void loginOut(String token) {
        template.delete(token);
    }

    @Override
    public void updateUserSpace(String userId,long userSpace) {
        UserInfo userInfo = getById(userId);
        userInfo.setUserSpace(userSpace+userInfo.getUserSpace());
        updateById(userInfo);
    }


}
