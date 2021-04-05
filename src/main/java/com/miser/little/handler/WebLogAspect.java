package com.miser.little.handler;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.miser.little.dto.base.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @program: chat-room-server
 * @description: 切面日志
 * @author: 宛雪锋
 * @create: 2021/01/03 11:16
 **/

@Slf4j
@Component
@Aspect
public class WebLogAspect {
    @Autowired
    private ParamResultLogSpice logSpice;

    /**
     * Pointcut 切入点
     */
    @Pointcut("execution(public * com.miser.little.controller.*.*(..))")
    public void webLog() {
    }

    /**
     * 环绕通知
     */
    @Around("webLog()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取请求URI
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        String uri = attributes.getRequest().getRequestURI().toString();

        //打印入参，如果需要打印耗时，则返回当前时间戳，否则返回： 0L
        long startTime = startLog(uri, joinPoint);

        Object result = joinPoint.proceed();

        //打印返回结果
        endLog(uri, result, startTime);
        return result;
    }

    private void endLog(String uri, Object result, long startTime) {
        StringBuffer logs = new StringBuffer();
        logs.append("结束请求，请求地址为：");
        logs.append(uri);
        logSpice.spliceResultLog(logs, result, startTime);
        log.info(logs.toString());
    }

    private long startLog(String uri, ProceedingJoinPoint joinPoint) {
        StringBuffer logs = new StringBuffer();
        logs.append("开始请求，请求地址为：");
        logs.append(uri);
        logs.append(";");
        //打印入参，如果需要打印耗时，则返回当前时间戳，否则返回： 0L
        long startTime = logSpice.spliceParamLog(logs, joinPoint);
        log.info(logs.toString());
        return startTime;
    }

}
