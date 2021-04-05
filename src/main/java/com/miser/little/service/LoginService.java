package com.miser.little.service;

import com.miser.little.dto.user.UserLoginDto;

public interface LoginService {
    void login(UserLoginDto userLoginDto);
}
