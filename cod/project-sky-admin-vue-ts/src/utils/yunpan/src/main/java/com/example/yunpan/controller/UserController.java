package com.example.yunpan.controller;

import com.example.yunpan.entity.UserInfo;
import com.example.yunpan.entity.dto.UserSpaceDto;
import com.example.yunpan.service.IFileInfoService;
import com.example.yunpan.service.IUserInfoService;
import com.example.yunpan.util.Constants;
import com.example.yunpan.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserInfoService userInfoService;
    @Autowired
    private IFileInfoService fileInfoService;

    @Autowired
    private RedisTemplate redisTemplate;
    @PostMapping("/updateAvatar/{id}")//头像更新
    public Result updateAvatar(@PathVariable("id") String id, MultipartFile file) throws IOException {
        if (file != null) {    // 现在有文件上传
            //eg: UUID + . + png
            String fileName = UUID.randomUUID() + "."
                    + file.getContentType().substring(file.getContentType().lastIndexOf("/") + 1);    // 创建文件名称
            //文件路径  位置 + 文件名
            String filePath = Constants.FILE_PATH+Constants.AVATAR_PATH+ fileName;
            //文件路径
            File saveFile = new File(filePath);
            if(!saveFile.exists()){
                saveFile.createNewFile();
            }
            file.transferTo(saveFile);        // 文件保存
            userInfoService.updateAvatar(id,filePath);
            return Result.build(null,"上传成功",200);
        } else {
            return Result.build(null,"上传失败",201);
        }
    }
    @GetMapping("/getAvatar/{id}")//头像回显
    public void getAvatar(HttpServletResponse response, @PathVariable("id") String id) {
        FileInputStream sourceImage=null;
        ServletOutputStream outputStream=null;
        try{
            String avatarPath=userInfoService.getAvatarPath(id);
            File file=new File(avatarPath);
            sourceImage=null;
            if(file.exists()) {
                sourceImage  = new FileInputStream(file);
                BufferedImage avatar = ImageIO.read(sourceImage);
                String sufixPhoto =avatarPath.split("\\.")[1];
                response.setContentType("image/"+sufixPhoto);
                outputStream = response.getOutputStream();
                ImageIO.write(avatar,sufixPhoto.toUpperCase(),outputStream);
            }
        } catch (IOException e) {
            if(outputStream!=null){
                try {
                    outputStream.close();
                    sourceImage.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }
    @PostMapping("/updatePasswordById")//登录后修改密码
    public Result updatePassword(@RequestParam("id") String id,@RequestParam("password") String password){
        userInfoService.updatePasswordById(id,password);
        return Result.build(null,"修改成功",200);
    }
    @PostMapping("/loginOut")//退出登录
    public Result loginOut(String token, HttpSession session){
        session.removeAttribute("token");
        userInfoService.loginOut(token);
        return Result.build(null,"退出成功",200);
    }
    @GetMapping("/userSpace")
    public Result getUserSpaceAndTotalSpace(HttpSession session){
        UserInfo userInfo=getUserInfo(session);
        String userId=userInfo.getUserId();
        UserInfo user = userInfoService.getById(userId);
        UserSpaceDto userSpaceDto = new UserSpaceDto(user.getUserSpace(),user.getTotalSpace());
        return Result.build(userSpaceDto,"查询成功",200);
    }
    UserInfo getUserInfo(HttpSession session){
        String token=(String)session.getAttribute("token");
        UserInfo userInfo = (UserInfo)redisTemplate.opsForValue().get(token);
        return userInfo;
    }
}
