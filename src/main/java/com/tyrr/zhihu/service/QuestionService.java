package com.tyrr.zhihu.service;

import com.tyrr.zhihu.entity.Answer;
import com.tyrr.zhihu.entity.Question;
import com.tyrr.zhihu.entity.User;
import com.tyrr.zhihu.repository.AnswerRepository;
import com.tyrr.zhihu.repository.QuestionRepository;
import com.tyrr.zhihu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@CacheConfig(cacheNames = "question")
@Service
public class QuestionService {
    @Autowired
    AnswerRepository answerRepository;
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    UserRepository userRepository;

    @Cacheable(key = "#id")
    public Question getQuestionById(int id){
        Question question = questionRepository.getOne(id);
        return question;
    }

    public List<Answer> findAllAnswer(Question question){
        List<Answer> answers = answerRepository.findAllByQuestion(question);
        return answers;
    }

    public List<Question> findAllQuestionn(){
        List<Question> all = questionRepository.findAll();
        return all;
    }


    public void add_qusetion(HttpSession session, String text,String content){
        User user = (User) session.getAttribute("__user__");
        Question question = new Question();
        question.setUser(userRepository.getOne(user.getId()));
        question.setText(text);
        question.setContent(content);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = df.format(new Date());
        question.setCreatetime(date);
        questionRepository.save(question);
    }

    @CacheEvict(key = "#id")
    public void delete_question(Integer id){
        Question one = questionRepository.getOne(id);
        List<Answer> allByQuestion = answerRepository.findAllByQuestion(one);
        answerRepository.deleteAll(allByQuestion);
        questionRepository.delete(one);
    }

    @CachePut(key = "#id")
    public Question update_question(Integer id, String text,String content){
        Question question = questionRepository.getOne(id);
        question.setText(text);
        question.setContent(content);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = df.format(new Date());
        question.setCreatetime(date);
        questionRepository.save(question);
        return question;
    }
}
