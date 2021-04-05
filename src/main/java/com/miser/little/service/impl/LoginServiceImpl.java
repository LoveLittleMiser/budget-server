package com.miser.little.service.impl;

import com.miser.little.dto.user.UserLoginDto;
import com.miser.little.service.LoginService;
import com.miser.little.service.UserService;
import com.miser.little.util.AESUtil;
import com.miser.little.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @program: chat-room-server
 * @description: 登录service
 * @author: 宛雪锋
 * @create: 2021/01/20 22:08
 **/
@Service
@Slf4j
public class LoginServiceImpl implements LoginService {
    @Value("${aes.key}")
    private String aesKey;
    @Autowired
    private UserService userService;

    @Override
    public void login(UserLoginDto userLoginDto) {
        RedisUtil.incr("LOGIN_TIME:"+userLoginDto.getAccountNumber(),1l);


        //密码进行解密
        String password = userLoginDto.getPassword();
        password = AESUtil.aesDecrypt(password, aesKey);


    }
}
