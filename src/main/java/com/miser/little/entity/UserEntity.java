package com.miser.little.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("char_user")
public class UserEntity extends BaseEntity{
    //主键
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    //用户名
    private String userName;
    //昵称
    private String nickname;
    //账号
    private String accountNumber;
    //密码
    private String password;
    //电话
    private String telephone;
    //邮箱
    private String mail;
    //地址
    private String address;
    //生日
    private String birthday;
    //角色ID
    private Long roleId;
}
