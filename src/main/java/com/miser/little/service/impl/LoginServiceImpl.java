package com.miser.little.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.miser.little.constant.BaseConstant;
import com.miser.little.dto.user.UserInforDto;
import com.miser.little.dto.user.UserLoginDto;
import com.miser.little.entity.UserEntity;
import com.miser.little.exception.ServiceException;
import com.miser.little.service.LoginService;
import com.miser.little.service.UserService;
import com.miser.little.util.AESUtil;
import com.miser.little.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

import static com.miser.little.serverEnum.RequestEnum.*;

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
    public void login(HttpServletResponse response, HttpServletRequest request, UserLoginDto userLoginDto) {
        //密码进行解密
        String password = userLoginDto.getPassword();
        password = AESUtil.aesDecrypt(password, aesKey);
        UserEntity userEntity = userService.selectUserByAccountNumb(userLoginDto.getAccountNumber());
        if (userEntity == null || (!StringUtils.equals(userEntity.getPassword(), password))){
            log.info(PASSWORD_ERROR.getValue());
            throw new ServiceException(PASSWORD_ERROR);
        }
        UserInforDto userInforDto = new UserInforDto();
        BeanUtils.copyProperties(userEntity, userInforDto);
        //RedisUtil.incr("LOGIN_TIME:"+userLoginDto.getAccountNumber(),1l);
        String tokenId = UUID.randomUUID().toString().replace("-", "");
        //设置超时时间
        RedisUtil.set(tokenId, userInforDto,60*60);

        Cookie tokenCookie = new Cookie(BaseConstant.TOKEN, tokenId);
        tokenCookie.setPath(request.getContextPath());
        Cookie userInfo = new Cookie(BaseConstant.USER_INFO, JSONObject.toJSONString(userInforDto));
        userInfo.setPath(request.getContextPath());

        response.addCookie(tokenCookie);
        response.addCookie(userInfo);
    }
}
