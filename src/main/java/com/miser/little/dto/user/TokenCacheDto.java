package com.miser.little.dto.user;

import lombok.Data;

/**
 * @program: chat-room-server
 * @description: token及信息接收方的信息
 * @author: 宛雪锋
 * @create: 2021/01/17 18:57
 **/
@Data
public class TokenCacheDto {
    //用户token
    private String token;
    //用户登录IP
    private String ip;
}
