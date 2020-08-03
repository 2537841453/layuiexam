package com.qssy.exam.webexam.service;

import com.github.pagehelper.Page;
import com.qssy.exam.webexam.entity.Code;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CodeService {
    int add(String titles, String explains, String contents);
    List<Code> findAll();
    int deleteById(int id);
    int EditById(String username,int id);
    List<Code> selectById(int id);
    int adds(Code code);
}
