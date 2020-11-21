package com.tyrr.zhihu.repository;

import com.tyrr.zhihu.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByTelephone(String telephone);
}
