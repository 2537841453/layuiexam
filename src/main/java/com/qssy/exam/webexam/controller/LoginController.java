package com.qssy.exam.webexam.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qssy.exam.webexam.commom.JsonToken;
import com.qssy.exam.webexam.entity.Code;
import com.qssy.exam.webexam.entity.Login;
import com.qssy.exam.webexam.service.CodeService;
import com.qssy.exam.webexam.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zzz
 */
@Controller
/*@RequestMapping("At")*/
public class LoginController {

    @Autowired
    private LoginService loginService;


    @GetMapping("/")
    public String login() {
        return "account/login";
    }

    @PostMapping("login")
    @ResponseBody
    public JsonToken toLogin(HttpSession session, @RequestParam("username") String username, @RequestParam("password") String password) {

        Login user=loginService.findAll(username);
        System.out.println(user);
      if(user==null){
          return new JsonToken(2,"账号或密码错误",0,0);
        }else{
          if(user.getUsername().equals(username)){
              if(user.getPassword().equals(password)){
                  session.setAttribute("user",user);
                  return new JsonToken(0,"登录成功",0,0);
              }else{
                  return new JsonToken(1,"密码错误",0,0);
              }
          }

      }
        return new JsonToken(0);
    }

    @RequestMapping("/out")
    public String scoreQuery(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/";
    }
}





