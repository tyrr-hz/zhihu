package com.tyrr.zhihu.repository;

import com.tyrr.zhihu.entity.Answer;
import com.tyrr.zhihu.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    List<Answer> findAllByQuestion(Question question);
}
