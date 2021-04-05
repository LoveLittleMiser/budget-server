package com.miser.little.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.miser.little.dto.base.ResponseDto;
import com.miser.little.dto.user.*;
import com.miser.little.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public ResponseDto<IPage<UserListResponseDto>> selectUserList(UserListRequestDto requestDto){
        IPage<UserListResponseDto> pageDto = userService.selectUserList(requestDto);
        return ResponseDto.success(pageDto);
    }

    @RequestMapping("/add")
    public ResponseDto addUser(@Valid UserAddDto userAddDto){
        userService.addUser(userAddDto);
        return ResponseDto.success();
    }

    @RequestMapping("/edit")
    public ResponseDto editUser(@RequestBody UserEditDto userEditDto){
        userService.editUser(userEditDto);
        return ResponseDto.success();
    }
}
