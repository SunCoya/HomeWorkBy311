package com.example.yunpan.controller;

import com.example.yunpan.entity.UserInfo;
import com.example.yunpan.entity.dto.UserInfoDto;
import com.example.yunpan.service.IUserInfoService;
import com.example.yunpan.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author baomidou
 * @since 2023-05-29
 */
@RestController
@RequestMapping("/userInfo")
public class UserLoginController {
    @Autowired
    private IUserInfoService userInfoService;
    @GetMapping("/getCodeImage")//验证码图片获取

    //type:0注册1登录2忘记密码
    public void getCodeImage(HttpSession session, HttpServletResponse response){
        response.setHeader("Pragma","no-cache");
        response.setHeader("Cache-Controller","no-cache");
        response.setDateHeader("Expires",0);
        response.setContentType("image/jpeg");
        BufferedImage codeImage = CreateVerifiCodeImage.getVerifiCodeImage();
        String code= String.valueOf(CreateVerifiCodeImage.getVerifiCode());
        ServletOutputStream outputStream=null;
        session.setAttribute(Constants.CHECK_CODE_KEY,code.toUpperCase());
        try {
            outputStream = response.getOutputStream();
            ImageIO.write(codeImage,"JPEG",outputStream);
        } catch (IOException e) {
            if(outputStream!=null){
                try {
                    outputStream.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            throw new RuntimeException(e);
        }
    }
    @RequestMapping("/sendEmailCode")//发送邮箱验证码
    public Result sendEmailCode(HttpSession session, Integer type, String email){
        String err=null;
        try{
            userInfoService.sendEmail(type,email);
        }catch (Exception e){
            if(e instanceof GlobalException)
                return Result.build(null,((GlobalException)e).getMessage(),201);
            else
                return Result.build(null,"发送失败",201);
        }finally {
            session.removeAttribute(Constants.CHECK_CODE_KEY_EMAIL);
        }
        return Result.ok();
    }
    @RequestMapping ("/register")//注册
    public Result register(HttpSession session, UserInfo userInfo, String checkCode, String emailCode,@RequestParam("type") Integer type){
        String err = null;
        try{
            String code=(String)session.getAttribute(Constants.CHECK_CODE_KEY);
            if(type==null&&!(checkCode.toUpperCase()).equals(code)){
                throw GlobalException.build("验证码错误");
            }
            userInfoService.register(userInfo,emailCode,type);
        }catch (Exception e){
            if(e instanceof GlobalException)
                return Result.build(null,((GlobalException)e).getMessage(),201);
            else
                return Result.build(null,"注册失败",201);
        }finally {
            session.removeAttribute(Constants.CHECK_CODE_KEY);
        }
        return Result.ok();
    }
    //重置密码
    @PutMapping("/updatePassword")
    public Result updatePassword(HttpSession session, UserInfo userInfo, String checkCode, String emailCode){

        try{
            String code=(String)session.getAttribute(Constants.CHECK_CODE_KEY);
            if(!(checkCode.toUpperCase()).equals(code)){
                throw GlobalException.build("验证码错误");
            }
            userInfoService.updatePassword(userInfo,emailCode);
        }catch (Exception e){
            if(e instanceof GlobalException)
                return Result.build(null,((GlobalException)e).getMessage(),201);
            else
                return Result.build(null,"修改失败",201);
        }finally {
            session.removeAttribute(Constants.CHECK_CODE_KEY);
        }
        return Result.ok();
    }

    @GetMapping("/login")//登录
    public Result login(HttpSession session, UserInfo userInfo,  String checkCode,@RequestParam("type") Integer type){
        UserInfoDto loginUser=null;
        try{
            if(type==null&&!(checkCode.toUpperCase()).equals((String)session.getAttribute(Constants.CHECK_CODE_KEY))){
                throw GlobalException.build("验证码错误");
            }
            loginUser = userInfoService.login(userInfo.getEmail(), userInfo.getPassword());
        }catch (Exception e){
            if(e instanceof GlobalException)
                return Result.build(null,((GlobalException)e).getMessage(),201);
            else
                return Result.build(null,"登陆失败",201);
        }finally {
            session.removeAttribute(Constants.CHECK_CODE_KEY);
        }
        session.setAttribute("token",loginUser.getToken());
        return Result.ok(loginUser);
    }

}
