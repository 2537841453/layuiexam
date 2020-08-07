package com.qssy.exam.webexam.dao;

import com.github.pagehelper.Page;
import com.qssy.exam.webexam.entity.Code;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CodeDao {
    int add(@Param("titles") String title, @Param("explains") String explain, @Param("contents") String content);
   List<Code> findAll();
    int deleteById(String id);
    int EditById(@Param("username") String username,@Param("id") String id);

    List<Code> selectById(String id);
    int adds(Code code);
}

