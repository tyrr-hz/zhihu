package com.tyrr.zhihu.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "answer")
public class Answer extends BaseEntity{

    @Column(length = 300)
    private String content;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;


    @ManyToOne(targetEntity = Question.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

}
