package com.tyrr.zhihu.controller;


import com.tyrr.zhihu.entity.Answer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class AnswerController extends BaseController{

    @PostMapping(value = "/add_answer",produces="application/json")
    public ModelAndView add_answer(HttpSession session, @RequestParam("content") String content,
                                   @RequestParam("question_id") Integer question_id){
        answerService.add_answer(session,content,question_id);
        return new ModelAndView("redirect:/detail/"+question_id);
    }

    @GetMapping("/delete_answer/{id}")
    public ModelAndView deleteAnswer(@PathVariable Integer id){
        Integer qusetion_id = answerService.delete_answer(id);
        return new ModelAndView("redirect:/detail/"+qusetion_id);
    }
    @GetMapping("/update_answer/{answer_id}")
    public ModelAndView toUpdateAnswer(@PathVariable("answer_id") Integer id){
        Answer answer = answerService.getAnswer(id);
        return new ModelAndView("update_answer.html","answer",answer);
    }
    @PostMapping("/update_answer/{answer_id}")
    public ModelAndView updateAnswer(@PathVariable("answer_id") Integer id,@RequestParam("content") String content){
        Integer question_id = answerService.updateAnswer(id, content);
        return new ModelAndView("redirect:/detail/"+question_id);
    }

}
