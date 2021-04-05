package com.miser.little.handler;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.miser.little.dto.base.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Collection;
import java.util.List;

/**
 * @program: chat-room-server
 * @description: 切面日志
 * @author: 宛雪锋
 * @create: 2021/01/03 11:16
 **/

@Slf4j
@Component
@Aspect
public class DbLogAspect {
    @Autowired
    private ParamResultLogSpice logSpice;

    /**
     * Pointcut 切入点
     */
    @Pointcut("execution(public * com.miser.little.mapper.*.*(..))")
    public void dbbLog() {
    }

    /**
     * 环绕通知
     */
    @Around("dbbLog()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();


        //打印入参，如果需要打印耗时，则返回当前时间戳，否则返回： 0L
        long startTime = startLog(className, methodName, joinPoint);

        Object result = joinPoint.proceed();

        //打印返回结果
        endLog(className, methodName, result, startTime);
        return result;
    }

    private void endLog(String className, String methodName, Object result, long startTime) {
        StringBuffer logs = new StringBuffer();
        logs.append("开始请求");
        logs.append(methodName);
        logs.append("方法;");
        logSpice.spliceResultLog(logs, result, startTime);
        log.info(logs.toString());
    }

    private long startLog(String className, String methodName, ProceedingJoinPoint joinPoint) {
        StringBuffer logs = new StringBuffer();
        logs.append("开始请求");
        logs.append(methodName);
        logs.append("方法;");
        //打印入参，如果需要打印耗时，则返回当前时间戳，否则返回： 0L
        long startTime = logSpice.spliceParamLog(logs, joinPoint);
        log.info(logs.toString());
        return startTime;
    }


}
