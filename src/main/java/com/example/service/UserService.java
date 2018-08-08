package com.example.service;

import com.example.common.util.IdGenerateUtil;
import com.example.dao.UserMapper;
import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    int addUser(User user);

    int batchAddUser(List<User> users);
}
