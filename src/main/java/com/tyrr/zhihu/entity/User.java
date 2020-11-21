package com.tyrr.zhihu.entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "user")
public class User extends BaseEntity{

    @Column(length = 20)
    private String username;

    @Column(length = 11)
    private String telephone;

    @Column(length = 50)
    private String password;

    @Column(length = 2)
    private int level;
}
