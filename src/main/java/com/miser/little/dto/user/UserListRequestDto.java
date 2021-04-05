package com.miser.little.dto.user;

import com.miser.little.dto.base.BasePageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@ApiModel
public class UserListRequestDto extends BasePageDto {
    @ApiModelProperty("数据ID")
    private Long id;
    @ApiModelProperty("用户名称")
    private String userName;
    @ApiModelProperty("昵称")
    private String nickname;
    @ApiModelProperty("账号")
    private String accountNumber;
    @ApiModelProperty("电话")
    private String telephone;
    @ApiModelProperty("邮箱")
    private String mail;
    @ApiModelProperty("地址")
    private String address;
    @ApiModelProperty("生日")
    private String birthday;

}
