package com.miser.little.dto.base;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @program: chat-room-server
 * @description:分页请求参数
 * @author: 宛雪锋
 * @create: 2021/01/01 18:16
 **/
@Data
@ApiModel
public class BasePageDto {
    private Integer pageSize;
    private Integer currentPage;
}
