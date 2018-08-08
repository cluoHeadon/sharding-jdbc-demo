package com.example.dao;

import com.example.dao.provider.UserMapperProvider;
import com.example.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Results(id = "user", value = {
        @Result(property = "userId", column = "user_id"),
        @Result(property = "name", column = "name"),
        @Result(property = "age", column = "age"),
        @Result(property = "address", column = "address")
    })
    @Select("select * from user order by user_id")
    List<User> getUsers();

    @ResultMap(value = "user")
    @Select("select * from user where user_id = #{userId}")
    User getUser(Integer userId);

    @Insert("insert into user(user_id, name, age, address) values(#{user.userId}, #{user.name}, #{user.age}, #{user.address})")
    int addUser(@Param("user") User user);

    @InsertProvider(type = UserMapperProvider.class, method = "insertAll")
    int batchAddUser(@Param("users") List<User> users);
}
