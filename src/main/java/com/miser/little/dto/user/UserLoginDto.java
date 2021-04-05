package com.miser.little.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class UserLoginDto{
    @ApiModelProperty("账号")
    private String accountNumber;
    @ApiModelProperty("密码")
    private String password;
}
