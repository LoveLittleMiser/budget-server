package com.miser.little.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.miser.little.dto.user.UserAddDto;
import com.miser.little.dto.user.UserEditDto;
import com.miser.little.dto.user.UserListRequestDto;
import com.miser.little.dto.user.UserListResponseDto;
import com.miser.little.entity.UserEntity;

public interface UserService {
    IPage<UserListResponseDto> selectUserList(UserListRequestDto requestDto);

    void addUser(UserAddDto userAddDto);

    void editUser(UserEditDto userEditDto);

    UserEntity selectUserByAccountNumb(String accountNumber);
}
