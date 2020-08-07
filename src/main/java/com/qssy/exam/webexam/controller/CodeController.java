package com.qssy.exam.webexam.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qssy.exam.webexam.commom.JsonToken;
import com.qssy.exam.webexam.entity.Code;
import com.qssy.exam.webexam.service.CodeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author zzz
 */
@Controller
public class CodeController {

    @Autowired
    private CodeService codeService;


    @GetMapping("code")
    public String test() {
        return "account/code";
    }

    @GetMapping("main")
    public String ttt() {
        return "common/admin";
    }

    @RequestMapping("code2")
    @ResponseBody
    public Map<String, Object> code2(Integer limit, Integer page) {
        // 使用Pagehelper传入当前页数和页面显示条数会自动为我们的select语句加上limit查询
        // 从他的下一条sql开始分页
        PageHelper.startPage(page, limit);
        List<Code> code=codeService.findAll();// 这是我们的sql
        // 使用pageInfo包装查询
        PageInfo<Code> rolePageInfo = new PageInfo<>(code);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",rolePageInfo.getTotal());
        map.put("data",rolePageInfo.getList());
        return map;
    }

    @GetMapping("delete")
    @ResponseBody
    public JsonToken delete(@RequestParam("id") String id){

        int code=codeService.deleteById(id);
        System.out.println("----------------------删除成功------------------------");
        return new JsonToken(0,"删除成功",code,code>0?true:false);
    }

    @RequestMapping("edit")
    @ResponseBody
    public JsonToken edit(Code code){
        int codes=codeService.EditById(code.getUsername(),code.getId());
        System.out.println("----------------------编辑成功---------------------------");
        return new JsonToken(1,"编辑成功",codes,0);
    }

    @GetMapping("selectById")
    @ResponseBody
    public Map<String, Object>  selectById(@RequestParam("keyword") String keyword,Integer limit, Integer page){
        PageHelper.startPage(page, limit);
        List<Code> code=codeService.selectById(keyword);// 这是我们的sql
        System.out.println(code);
        // 使用pageInfo包装查询
        PageInfo<Code> rolePageInfo = new PageInfo<>(code);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",rolePageInfo.getTotal());
        map.put("data",rolePageInfo.getList());
        return map;
    }

    @RequestMapping("add")
    @ResponseBody
    public JsonToken add(Code code){
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        code.setId(id);
        //System.out.println(code.getId());
        int codes=codeService.adds(code);
        System.out.println("-----------------添加成功-------------------");
        return new JsonToken(0,"添加成功",codes,codes>0?true:false);
    }
}





