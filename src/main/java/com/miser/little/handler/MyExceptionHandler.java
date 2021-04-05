package com.miser.little.handler;

import com.miser.little.dto.base.ResponseDto;
import com.miser.little.exception.ServiceException;
import com.miser.little.serverEnum.RequestEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: budget-server
 * @description: 全局异常捕获
 * @author: 宛雪锋
 * @create: 2021/04/05 19:13
 **/
@Slf4j
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value = ServiceException.class)//指定拦截的异常
    public Object errorHandler(ServiceException e) throws Exception{
        log.info("访问出现异常,",e);
        return ResponseDto.error(e.getRequestEnum());
    }
    @ExceptionHandler(value = Exception.class)//指定拦截的异常
    public Object errorHandler(Exception e) throws Exception{
        log.error("访问出未知异常,",e);
        return ResponseDto.error(RequestEnum.ERROR);
    }
}
