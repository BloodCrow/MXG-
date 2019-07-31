package com.czxy.service;

import com.czxy.dao.UserMapper;
import com.czxy.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class UserService {
    @Resource
    private UserMapper userMapper;
    public User register(User user){
        User register = userMapper.register(user);

        if (register==null){
            userMapper.insert(user);
        }

        return register;
    }

    public User login(User user){
        User login = userMapper.login(user);
        return login;
    }
}
