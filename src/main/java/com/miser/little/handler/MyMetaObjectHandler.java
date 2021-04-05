package com.miser.little.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    private static final String CREATE_DATE = "createDate";
    private static final String UPDATE_DATE = "updateDate";
    private static final String CREATE_BY = "createBy";
    private static final String UPDATE_BY = "updateBy";


    @Override
    public void insertFill(MetaObject metaObject) {
        Date date = new Date();
        String accountNumber = "admin666";
        //规则和默认规则不同时 不能进行覆盖处理
        this.strictInsertFill(metaObject, CREATE_DATE, Date.class, date);
        this.strictInsertFill(metaObject, UPDATE_DATE, Date.class, date);
        this.strictInsertFill(metaObject, CREATE_BY, String.class, accountNumber);
        this.strictInsertFill(metaObject, UPDATE_BY, String.class, accountNumber);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Date date = new Date();
        String accountNumber = "admin666";
        this.strictInsertFill(metaObject, UPDATE_DATE, Date.class, date);
        this.strictInsertFill(metaObject, UPDATE_BY, String.class, accountNumber);
    }
}
