package com.miser.little.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @program: chat-room-server
 * @description: 缓存用户信息
 * @author: 宛雪锋
 * @create: 2021/01/17 13:26
 **/
@Data
public class UserCacheDto {
    //用户ID
    private Long id;
    //用户名
    private String userName;
    //昵称
    private String nickname;
    //账号
    private String accountNumber;
}
