package com.miser.little.constant;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @program: chat-room-server
 * @description: 公用常量
 * @author: 宛雪锋
 * @create: 2021/01/17 19:13
 **/
public class BaseConstant {
    //当前机器IP
    public static String IP = null;
    //
    //public static final String USER_TOKEN_ID = "USER_TOKEN_ID";

    public static final String TOKEN = "token";

    public static final String USER_INFO = "userInfo";




    static {
        try {
            IP = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
