package com.example.yunpan.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDto {
    private String nickName;
    private String userId;
    private Boolean isAdmin;
    private String avatar;
    private Long useSpace;
    private Long totalSpace;
    private String token;

}
