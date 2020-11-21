package com.tyrr.zhihu.service;

import com.tyrr.zhihu.entity.User;
import com.tyrr.zhihu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public boolean add_user(User user,String password2){
        if (user.getPassword().equals(password2)){
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date = df.format(new Date());
            user.setCreatetime(date);
            userRepository.save(user);
            return true;
        }else {
            return false;
        }

    }

    public User findByTel(String telephone){

        return userRepository.findByTelephone(telephone);
    }

    public void logout(HttpSession session){
        session.removeAttribute("__user__");
    }
}
