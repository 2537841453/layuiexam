package com.qssy.exam.webexam.dao;


import com.qssy.exam.webexam.entity.User;

public interface UserDao {
    User findAll(String username);
    User addUser(User user);
}

