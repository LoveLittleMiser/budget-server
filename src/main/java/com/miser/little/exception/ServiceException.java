package com.miser.little.exception;

import com.miser.little.serverEnum.RequestEnum;
import lombok.Getter;

/**
 * @program: budget-server
 * @description: 请求异常
 * @author: 宛雪锋
 * @create: 2021/04/05 19:06
 **/
@Getter
public class ServiceException extends RuntimeException{
    private RequestEnum requestEnum;

    public ServiceException(RequestEnum requestEnum){
        this.requestEnum = requestEnum;
    }



}
