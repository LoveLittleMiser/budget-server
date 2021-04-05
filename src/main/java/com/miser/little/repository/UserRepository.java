package com.miser.little.repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miser.little.dto.user.UserListRequestDto;
import com.miser.little.dto.user.UserListResponseDto;
import com.miser.little.entity.UserEntity;
import com.miser.little.mapper.UserMapper;
import org.springframework.stereotype.Repository;


@Repository
public class UserRepository extends ServiceImpl<UserMapper, UserEntity> {

    public IPage<UserListResponseDto> selectUserList(Page<UserListResponseDto> page, UserListRequestDto requestDto) {
        IPage<UserListResponseDto> iPage = baseMapper.selectUserList(page, requestDto);
        return iPage;
    }
}
