package com.miser.little.handler;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.miser.little.dto.base.ResponseDto;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;

/**
 * @program: chat-room-server
 * @description: 处理请求和返回参数的日志拼接
 * @author: 宛雪锋
 * @create: 2021/01/03 12:57
 **/
@Component
public class ParamResultLogSpice {
    @Value("${logTime:false}")
    private Boolean logTime;

    public void spliceResultLog(StringBuffer logs, Object result, long startTime) {
        if (result == null) {
            logs.append("该请求无返回结果;");
            spliceTime(logs, startTime);
            return;
        }

        if (result instanceof ResponseDto) {
            ResponseDto responseDto = (ResponseDto) result;
            Object data = responseDto.getData();
            spliceResultLogByType(logs, data);
        } else {
            spliceResultLogByType(logs, result);
        }
        spliceTime(logs, startTime);
    }

    private void spliceTime(StringBuffer logs, long startTime) {
        if (logTime) {
            long endTime = System.currentTimeMillis();
            long spendTime = endTime - startTime;
            logs.append("请求耗时：");
            logs.append(spendTime);
            logs.append(";");
        }
    }

    private void spliceResultLogByType(StringBuffer logs, Object result) {
        if (result == null){
            logs.append("该请求返回结果为空;");
            return;
        }
        if (result instanceof IPage) {
            IPage page = (IPage) result;
            List records = page.getRecords();
            if (CollectionUtils.isEmpty(records)) {
                logs.append("分页返回结果为空");
                return;
            }
            logs.append("分页返回结果条数为：");
            logs.append(records.size());
            logs.append(";");
            return;
        } else if (result instanceof Collection) {
            Collection collection = (Collection) result;
            logs.append("列表返回结果条数为：");
            logs.append(collection.size());
            logs.append(";");
        } else {
            logs.append("返回结果为：");
            logs.append(result);
            logs.append(";");
        }

    }

    public long spliceParamLog(StringBuffer logs, ProceedingJoinPoint joinPoint) {
        long startTime = 0l;
        //由于根据环境不同需要区分，所以根据配置文件进行判断
        if (logTime) {
            startTime = System.currentTimeMillis();
        }

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String[] paramNames = signature.getParameterNames();
        Object[] paramValues = joinPoint.getArgs();
        if (paramNames.length == 0) {
            logs.append("该请求无参数。");
            return startTime;
        }

        //参数的个数，值的个数  确定方法的安全性
        if (paramNames.length != paramValues.length){
            logs.append("参数的个数，值的个数不一致");

        }

        //拼接参数
        for (int i = 0; i < paramNames.length; i++) {
            logs.append("入参名称为：");
            logs.append(paramNames[i]);
            logs.append(",");
            logs.append("参数为：");
            logs.append(paramValues[i]);
            logs.append(";");
        }
        return startTime;
    }
}
