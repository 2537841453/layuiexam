package com.qssy.exam.webexam.service.impl;

import com.qssy.exam.webexam.dao.LoginDao;
import com.qssy.exam.webexam.entity.Login;
import com.qssy.exam.webexam.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;


    @Override
    public Login findAll(String username) {
        return loginDao.findAll(username);
    }
}
