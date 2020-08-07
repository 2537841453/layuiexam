package com.qssy.exam.webexam.dao;


import com.qssy.exam.webexam.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    User findAll(String username);
    int addUser(User user);
}

