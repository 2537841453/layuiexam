package com.qssy.exam.webexam.service.impl;


import com.qssy.exam.webexam.dao.CodeDao;
import com.qssy.exam.webexam.entity.Code;
import com.qssy.exam.webexam.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CodeServiceImpl implements CodeService {

    @Autowired
    private CodeDao codeDao;


    @Override
    public int add(String titles, String explains, String contents) {
        return codeDao.add(titles,explains,contents);
    }

    @Override
    public List<Code> findAll() {
        return codeDao.findAll();
    }

    @Override
    public int deleteById(String id) {
        return codeDao.deleteById(id);
    }

    @Override
    public int EditById(String username, String id) {
        return codeDao.EditById(username,id);
    }


    @Override
    public List<Code> selectById(String id) {
        return codeDao.selectById(id);
    }

    @Override
    public int adds(Code code) {
        return codeDao.adds(code);
    }


}
