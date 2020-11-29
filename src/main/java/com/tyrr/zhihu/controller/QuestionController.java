package com.tyrr.zhihu.controller;


import com.tyrr.zhihu.entity.Answer;
import com.tyrr.zhihu.entity.Question;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class QuestionController extends BaseController{

    @GetMapping("/detail/{question_id}")
    public ModelAndView detail(@PathVariable("question_id") Integer question_id,HttpSession session){
        Question question = questionService.getQuestionById(question_id);
        List<Answer> answers = questionService.findAllAnswer(question);
        return new ModelAndView("detail.html", Map.of("question", question, "answers", answers));

    }

//    @LoginCheck(value = "question")
    @GetMapping("/add_question")
    public ModelAndView question(){
        return new ModelAndView("/question.html");
    }

    @PostMapping("/add_question")
    public ModelAndView add_question(HttpSession session,
                                     @RequestParam("text") String text, @RequestParam("content") String content){
        questionService.add_qusetion(session,text,content);

        return new ModelAndView("redirect:/");
    }

    @GetMapping("/delete_question/{question_id}")
    public ModelAndView delete_question(@PathVariable("question_id") Integer question_id){
        questionService.delete_question(question_id);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/update_question/{question_id}")
    public ModelAndView getUpdateQuestion(@PathVariable("question_id") Integer question_id){
        Question question = questionService.getQuestionById(question_id);
        return new ModelAndView("update_question.html","question",question);
    }

    @PostMapping("/update_question/{question_id}")
    public ModelAndView updateQusetion(@PathVariable("question_id") Integer id,
                                       @RequestParam("text") String text,
                                       @RequestParam("content") String content){
        Question question = questionService.update_question( id, text, content);
        return new ModelAndView("redirect:/detail/"+id);

    }
}
