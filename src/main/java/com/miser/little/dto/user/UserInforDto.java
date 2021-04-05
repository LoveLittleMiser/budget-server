package com.miser.little.dto.user;

import lombok.Data;

/**
 * @program: budget-server
 * @description: 用户基本信息
 * @author: 宛雪锋
 * @create: 2021/04/05 19:33
 **/
@Data
public class UserInforDto {
    //用户名
    private String userName;
    //昵称
    private String nickname;
    //账号
    private String accountNumber;
    //密码
    private String password;
    //电话
    private String telephone;
    //邮箱
    private String mail;
    //地址
    private String address;
    //生日
    private String birthday;
}
