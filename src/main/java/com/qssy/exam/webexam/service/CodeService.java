package com.qssy.exam.webexam.service;

import com.github.pagehelper.Page;
import com.qssy.exam.webexam.entity.Code;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CodeService {
    int add(String titles, String explains, String contents);
    List<Code> findAll();
    int deleteById(String id);
    int EditById(String username,String id);
    List<Code> selectById(String id);
    int adds(Code code);
}
