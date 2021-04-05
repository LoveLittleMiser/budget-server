package com.miser.little.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miser.little.entity.RoleEntity;
import com.miser.little.mapper.RoleMapper;
import org.springframework.stereotype.Repository;


@Repository
public class RoleRepository extends ServiceImpl<RoleMapper, RoleEntity> {

}
