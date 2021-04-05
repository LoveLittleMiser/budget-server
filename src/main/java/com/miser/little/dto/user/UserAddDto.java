package com.miser.little.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Data
@ToString(callSuper = true)
@ApiModel
public class UserAddDto {
    @ApiModelProperty("用户名称")
    private String userName;
    @ApiModelProperty("昵称")
    private String nickname;
    @ApiModelProperty("账号")
    @NotBlank(message = "账号不能为空")
    private String accountNumber;
    @NotBlank(message = "密码不能为空")
    private String password;
    @ApiModelProperty("电话")
    private String telephone;
    @ApiModelProperty("邮箱")
    private String mail;
    @ApiModelProperty("地址")
    private String address;
    @ApiModelProperty("生日")
    private String birthday;
}
