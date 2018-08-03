package com.example.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户
 *
 * @author cluo
 * @date 2018/08/02
 * @version
 * @copyright(c) gome inc Gome Co.,LTD
 */
public class User {
    private Integer user_id;
    private String name;
    private Integer age;
    private String address;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

