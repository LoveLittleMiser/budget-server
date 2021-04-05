package com.miser.little.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.miser.little.dto.user.UserAddDto;
import com.miser.little.dto.user.UserEditDto;
import com.miser.little.dto.user.UserListRequestDto;
import com.miser.little.dto.user.UserListResponseDto;
import com.miser.little.entity.UserEntity;
import com.miser.little.repository.UserRepository;
import com.miser.little.service.UserService;
import com.miser.little.util.AESUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Value("${aes.key}")
    private String aesKey;

    @Override
    @Transactional
    public IPage<UserListResponseDto> selectUserList(UserListRequestDto requestDto) {
        requestDto.setCurrentPage(1);
        requestDto.setPageSize(20);
        //查询总条数
        Page<UserListResponseDto> page = new Page<>(requestDto.getCurrentPage(), requestDto.getPageSize());
        IPage<UserListResponseDto> iPage = userRepository.selectUserList(page,requestDto);

        IPage<UserListResponseDto> iPage1 = userRepository.selectUserList(page,requestDto);
        return iPage;
    }

    @Override
    public void addUser(UserAddDto userAddDto) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userAddDto,userEntity);

        //密码进行解密
        String password = userEntity.getPassword();
        password = AESUtil.aesDecrypt(password, aesKey);
        //进行二次加密
        userEntity.setPassword(AESUtil.getMd5(password));
        userRepository.save(userEntity);
    }

    @Override
    public void editUser(UserEditDto userEditDto) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userEditDto,userEntity);
        String password = userEntity.getPassword();
        if (StringUtils.isNoneBlank(password)){
            password = AESUtil.aesDecrypt(password, aesKey);
            //进行二次加密
            userEntity.setPassword(AESUtil.getMd5(password));
        }
        userRepository.updateById(userEntity);
    }

}
