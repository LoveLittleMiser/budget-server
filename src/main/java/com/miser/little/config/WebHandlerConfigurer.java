package com.miser.little.config;

import com.miser.little.handler.MyInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: chat-room-server
 * @description: Handler拦截配置文件
 * @author: 宛雪锋
 * @create: 2021/01/03 13:40
 **/
public class WebHandlerConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/emp/toLogin", "/emp/login", "/js/**", "/css/**", "/images/**");
    }
}
