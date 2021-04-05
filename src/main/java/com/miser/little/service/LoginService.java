package com.miser.little.service;

import com.miser.little.dto.user.UserLoginDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LoginService {
    void login(HttpServletResponse response, HttpServletRequest request, UserLoginDto userLoginDto);
}
