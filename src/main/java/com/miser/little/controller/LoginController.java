package com.miser.little.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.miser.little.dto.base.ResponseDto;
import com.miser.little.dto.user.UserListRequestDto;
import com.miser.little.dto.user.UserListResponseDto;
import com.miser.little.dto.user.UserLoginDto;
import com.miser.little.service.LoginService;
import com.miser.little.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: chat-room-server
 * @description: 登录
 * @author: 宛雪锋
 * @create: 2021/01/20 21:48
 **/
@RestController
@RequestMapping("/sso")
@Slf4j
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public ResponseDto login(@RequestBody UserLoginDto userLoginDto){

        loginService.login(userLoginDto);

        return ResponseDto.success();
    }

}
