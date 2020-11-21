package com.tyrr.zhihu.controller;

import com.tyrr.zhihu.annotation.AddUser;
import com.tyrr.zhihu.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController extends BaseController{

    @GetMapping("/regist")
    public ModelAndView regist(){
        return new ModelAndView("regist.html");
    }

    @PostMapping("/regist")
    public ModelAndView add_user(User user, @RequestParam("password2") String password2, HttpServletResponse servletResponse){
        boolean b = userService.add_user(user, password2);
        if (b == true){
            return new ModelAndView("redirect:/login");
        }else{
            return new ModelAndView("/regist.html","msg","密码不一致");
        }

    }
}
