package com.example.service.impl;

import com.example.common.util.IdGenerateUtil;
import com.example.dao.UserMapper;
import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getUsers() {
        return userMapper.getUsers();
    }

    @Override
    public int addUser(User user) {
        user.setUserId(IdGenerateUtil.getUserId());
        return userMapper.addUser(user);
    }
}
