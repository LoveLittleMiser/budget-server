package com.miser.little.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.util.Date;

@Data
public class BaseEntity {
    //状态
    @TableLogic
    private String status;
    //版本号
    @Version
    private Long version;
    //创建人
    @TableField(fill = FieldFill.INSERT)
    private String createBy;
    //更新人
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateBy;
    //创建时间
    @TableField(fill = FieldFill.INSERT)
    private Date createDate;
    //更新时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateDate;
}
