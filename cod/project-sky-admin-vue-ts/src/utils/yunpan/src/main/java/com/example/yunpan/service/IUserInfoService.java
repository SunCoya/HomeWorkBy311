package com.example.yunpan.service;

import com.example.yunpan.entity.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.yunpan.entity.dto.UserInfoDto;
import com.example.yunpan.util.GlobalException;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author baomidou
 * @since 2023-05-29
 */
public interface IUserInfoService extends IService<UserInfo> {

    void sendEmail(Integer type, String email) throws GlobalException;

    void register(UserInfo userInfo, String emailCode,Integer type) throws GlobalException;

    UserInfoDto login(String email, String password) throws GlobalException;

    void updatePassword(UserInfo userInfo, String emailCode) throws GlobalException;

    void updateAvatar(String id, String filePath);

    String getAvatarPath(String id);

    void updatePasswordById(String id,String password);

    void loginOut(String token);

    void updateUserSpace(String userId,long userSpace);
}
