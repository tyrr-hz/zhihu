package com.tyrr.zhihu.config;

import com.tyrr.zhihu.component.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class MyServerConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new LoginHandlerInterceptor());
        interceptorRegistration.addPathPatterns("/**");// /**标识拦截所有
        interceptorRegistration.excludePathPatterns(List.of("/","/detail/*","/login","/regist"));
    }

}
