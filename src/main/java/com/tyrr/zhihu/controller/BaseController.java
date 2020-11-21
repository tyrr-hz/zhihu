package com.tyrr.zhihu.controller;

import com.tyrr.zhihu.annotation.AddUser;
import com.tyrr.zhihu.service.AnswerService;
import com.tyrr.zhihu.service.QuestionService;
import com.tyrr.zhihu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
@AddUser(value = "addUser")
public class BaseController {
    @Autowired
    AnswerService answerService;

    @Autowired
    QuestionService questionService;

    @Autowired
    UserService userService;
}
