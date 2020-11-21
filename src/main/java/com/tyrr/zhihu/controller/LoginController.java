package com.tyrr.zhihu.controller;

import com.tyrr.zhihu.annotation.AddUser;
import com.tyrr.zhihu.entity.Question;
import com.tyrr.zhihu.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController extends BaseController {
    @GetMapping("/login")
    public ModelAndView tologin(){
        return new ModelAndView("login.html");
    }

    @PostMapping("/login")
    public ModelAndView login(@RequestParam String telephone, @RequestParam String password, HttpSession session){
        User user = userService.findByTel(telephone);
        if (user != null && user.getPassword().equals(password)){
            session.setAttribute("__user__",user);
            List<Question> questions = questionService.findAllQuestionn();
            System.out.println();
            return new ModelAndView("redirect:/");
        }else {
            return new ModelAndView("login.html","msg","用户密码错误");
        }

    }
}
