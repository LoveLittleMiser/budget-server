package com.miser.little.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("char_role_resource")
public class RoleResourceEntity extends BaseEntity{
    //主键
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    //用户名
    private Long roleId;
    //角色编码
    private String resourceId;
}
