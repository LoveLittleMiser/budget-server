package com.miser.little.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.models.auth.In;
import lombok.Data;

@Data
@TableName("char_resource")
public class ResourceEntity extends BaseEntity{
    //主键
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    //用户名
    private String resourceName;
    //昵称
    private String resourceCode;
    //账号
    private String resourceType;
    //密码
    private String resourceUrl;
    //电话
    private Integer resourceSort;
}
