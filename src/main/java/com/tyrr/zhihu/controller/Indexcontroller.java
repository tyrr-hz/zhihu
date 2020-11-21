package com.tyrr.zhihu.controller;
import com.tyrr.zhihu.annotation.AddUser;
import com.tyrr.zhihu.entity.Question;
import com.tyrr.zhihu.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


@Controller
public class Indexcontroller extends BaseController {
    @GetMapping("/")
    public ModelAndView getIndex(HttpSession session){
        List<Question> questions = questionService.findAllQuestionn();
        return new ModelAndView("index.html", Map.of("questions",questions));
    }
}
