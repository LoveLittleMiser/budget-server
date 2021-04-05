package com.miser.little.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.miser.little.dto.user.UserListRequestDto;
import com.miser.little.dto.user.UserListResponseDto;
import com.miser.little.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
    IPage<UserListResponseDto> selectUserList(Page<UserListResponseDto> page,@Param("requestDto") UserListRequestDto requestDto);
}
