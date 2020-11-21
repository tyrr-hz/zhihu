package com.tyrr.zhihu.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.mapping.Set;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "question")
public class Question extends BaseEntity{

    @Column(length = 50)
    private String text;

    @Column(length = 500)
    private String content;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;


}
