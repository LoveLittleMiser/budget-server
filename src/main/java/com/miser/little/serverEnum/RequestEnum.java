package com.miser.little.serverEnum;


import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
@Getter
public enum RequestEnum {

    SUCCESS("000000","成功"),
    ERROR("999999","系统异常"),
    //用户模块异常编码
    PASSWORD_ERROR("100100","用户名或密码错误，请确认！"),



    ;

    private String code;
    private String value;

    private RequestEnum(String code, String value){
        this.code = code;
        this.value = value;
    };

    public static RequestEnum getEnumByCode(String code){
        if(StringUtils.isBlank(code)){
            return null;
        }
        RequestEnum[] enums = RequestEnum.values();
        for (int i = 0; i < enums.length; i++) {
            //返回<4444,"系统异常">
            if(StringUtils.equals(code,enums[i].getCode())){
                return enums[i];
            }
        }
        return null;
    }

    public static String getValueByCode(String code){
        if(StringUtils.isBlank(code)){
            return "";
        }
        RequestEnum[] enums = RequestEnum.values();
        for (int i = 0; i < enums.length; i++) {
            if(StringUtils.equals(code,enums[i].getCode())){
                //返回“系统异常”
                return enums[i].getValue();
            }
        }
        return ""; 
    }
}
