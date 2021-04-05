package com.miser.little.controller;

import com.miser.little.dto.base.ResponseDto;
import com.miser.little.dto.user.UserLoginDto;
import com.miser.little.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    public ResponseDto login(HttpServletResponse response, HttpServletRequest request, @RequestBody UserLoginDto userLoginDto){
        loginService.login(response,request,userLoginDto);
        return ResponseDto.success();
    }

}
