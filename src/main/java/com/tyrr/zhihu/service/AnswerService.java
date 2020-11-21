package com.tyrr.zhihu.service;

import com.tyrr.zhihu.entity.Answer;
import com.tyrr.zhihu.entity.Question;
import com.tyrr.zhihu.entity.User;
import com.tyrr.zhihu.repository.AnswerRepository;
import com.tyrr.zhihu.repository.QuestionRepository;
import com.tyrr.zhihu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class AnswerService {
    @Autowired
    AnswerRepository answerRepository;
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    UserRepository userRepository;

    public void add_answer(HttpSession session, String content, Integer question_id){
        User user = (User) session.getAttribute("__user__");
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setUser(userRepository.getOne(user.getId()));
        answer.setQuestion(questionRepository.getOne(question_id));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = df.format(new Date());
        answer.setCreatetime(date);
        answerRepository.save(answer);
    }
    public List<Answer> findAllAnswer(Question question){
        List<Answer> answers = answerRepository.findAllByQuestion(question);
        return answers;
    }
    public int delete_answer(Integer id){
        Answer answer = answerRepository.getOne(id);
        Question question = answer.getQuestion();
        answerRepository.delete(answer);
        return question.getId();
    }
    public Answer getAnswer(Integer id){
        return answerRepository.getOne(id);
    }
    public Integer updateAnswer(Integer id,String content){
        Answer answer = answerRepository.getOne(id);
        answer.setContent(content);
        answerRepository.save(answer);
        return answer.getQuestion().getId();
    }
}
