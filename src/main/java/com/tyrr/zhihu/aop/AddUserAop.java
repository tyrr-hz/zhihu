package com.tyrr.zhihu.aop;


import com.tyrr.zhihu.entity.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Aspect
@Component
public class AddUserAop {

    @Around("@within(com.tyrr.zhihu.annotation.AddUser)")
    public ModelAndView loginCheck(ProceedingJoinPoint joinPoint) throws Throwable {
        ModelAndView modelAndView = (ModelAndView) joinPoint.proceed();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        User user = (User)request.getSession().getAttribute("__user__");
        if(user != null){
            modelAndView.addObject("user",user);
            return modelAndView;
        }else{
            return modelAndView;
        }

    }
}
