package com.example.dao;

import com.example.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Results({
        @Result(property = "user_id", column = "user_id"),
        @Result(property = "name", column = "name"),
        @Result(property = "age", column = "age"),
        @Result(property = "address", column = "address"),
    })
    @Select("select * from user")
    List<User> getUsers();

    @Insert("insert into user(user_id, name, age, address) values(#{user.user_id}, #{user.name}, #{user.age}, #{user.address})")
    int addUser(@Param("user") User user);
}
