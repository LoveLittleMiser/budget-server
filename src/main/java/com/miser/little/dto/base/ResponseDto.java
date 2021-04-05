package com.miser.little.dto.base;

import com.miser.little.serverEnum.RequestEnum;
import lombok.Data;
import java.util.Date;

@Data
public class ResponseDto<T> {
    //返回信息
    private String message;
    //返回编码
    private String code;
    //返回时间（方便查找错误的时间）
    private Date time;
    //返回数据
    private T data;


    public static <I> ResponseDto<I> success(I data){
        ResponseDto<I> responseDto = new ResponseDto<>();
        responseDto.setData(data);
        responseDto.setTime(new Date());
        responseDto.setCodeAndMessage(RequestEnum.SUCCESS);
        return responseDto;
    }

    public static <I> ResponseDto<I> success(){
        ResponseDto<I> responseDto = new ResponseDto<>();
        responseDto.setTime(new Date());
        responseDto.setCodeAndMessage(RequestEnum.SUCCESS);
        return responseDto;
    }

    private void setCodeAndMessage(RequestEnum requestEnum){
        this.code = requestEnum.getCode();
        this.message = requestEnum.getValue();
    }

    public static <I> ResponseDto<I> error(RequestEnum requestEnum){
        ResponseDto<I> responseDto = new ResponseDto<>();
        responseDto.setTime(new Date());
        responseDto.setCodeAndMessage(requestEnum);
        return responseDto;
    }

}
