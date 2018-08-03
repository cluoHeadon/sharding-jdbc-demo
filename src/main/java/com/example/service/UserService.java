package com.example.service;

import com.example.common.util.IdGenerateUtil;
import com.example.dao.UserMapper;
import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public List<User> getUsers() {
        return userMapper.getUsers();
    }

    public int addUser(User user) {
        user.setUser_id(IdGenerateUtil.getUserId());
        return userMapper.addUser(user);
    }
}
