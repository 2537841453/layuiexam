package com.qssy.exam.webexam.service.impl;

import com.qssy.exam.webexam.dao.UserDao;
import com.qssy.exam.webexam.entity.User;
import com.qssy.exam.webexam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public User findAll(String username) {
        return userDao.findAll(username);
    }

    @Override
    public User addUser(User user) {
        return userDao.addUser(user);
    }
}
