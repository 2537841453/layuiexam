package com.qssy.exam.webexam.dao;


import com.qssy.exam.webexam.entity.Login;

public interface LoginDao {
    Login findAll(String username);
}

