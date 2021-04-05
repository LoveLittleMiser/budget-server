package com.miser.little.ServerEnum;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
@Getter
public enum StatusEnum {
    DELETED("0","已删除"),
    UNDELETE("1","未删除"),
    ;

    private String code;
    private String value;
    private StatusEnum(String code, String value){
        this.code = code;
        this.value = value;
    };

    public static StatusEnum getEnumByCode(String code){
        if(StringUtils.isBlank(code)){
            return null;
        }
        StatusEnum[] enums = StatusEnum.values();
        for (int i = 0; i < enums.length; i++) {
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
        StatusEnum[] enums = StatusEnum.values();
        for (int i = 0; i < enums.length; i++) {
            if(StringUtils.equals(code,enums[i].getCode())){
                return enums[i].getValue();
            }
        }
        return "";
    }
}
