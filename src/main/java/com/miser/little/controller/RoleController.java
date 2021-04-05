package com.miser.little.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.miser.little.dto.base.ResponseDto;
import com.miser.little.dto.user.UserEditDto;
import com.miser.little.dto.user.UserListRequestDto;
import com.miser.little.dto.user.UserListResponseDto;
import com.miser.little.service.RoleService;
import com.miser.little.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
@Slf4j
public class RoleController {
    @Autowired
    private RoleService roleService;

//    @RequestMapping("/list")
//    public ResponseDto<IPage<UserListResponseDto>> selectUserList(UserListRequestDto requestDto){
//        requestDto.setCurrentPage(1);
//        requestDto.setPageSize(1000);
//        requestDto.setUserName("张三");
//        IPage<UserListResponseDto> pageDto = userService.selectUserList(requestDto);
//        return ResponseDto.success(pageDto);
//    }
//
    @RequestMapping("/add")
    public ResponseDto addUser(UserListRequestDto requestDto){
//        roleService.addRole(requestDto);
        return ResponseDto.success();
    }
//
//    @RequestMapping("/edit")
//    public ResponseDto editUser(@RequestBody UserEditDto userEditDto){
//        userService.editUser(userEditDto);
//        return ResponseDto.success();
//    }


}
