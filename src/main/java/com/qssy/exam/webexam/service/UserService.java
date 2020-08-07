package com.qssy.exam.webexam.service;


import com.qssy.exam.webexam.entity.User;

public interface UserService {
    User findAll(String username);
    int addUser(User user);
}
