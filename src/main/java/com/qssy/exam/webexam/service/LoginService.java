package com.qssy.exam.webexam.service;


import com.qssy.exam.webexam.entity.Login;

public interface LoginService {
    Login findAll(String username);
}
