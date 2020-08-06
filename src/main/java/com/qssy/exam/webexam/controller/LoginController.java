package com.qssy.exam.webexam.controller;

import com.qssy.exam.webexam.commom.JsonToken;
import com.qssy.exam.webexam.entity.User;
import com.qssy.exam.webexam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.apache.shiro.crypto.hash.Md5Hash;

import javax.servlet.http.HttpSession;

/**
 * @author zzz
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;


    @GetMapping("/")
    public String login() {
        return "account/login";
    }

    @PostMapping("login")
    @ResponseBody
    public JsonToken toLogin(HttpSession session, @RequestParam("username") String username, @RequestParam("password") String password,@RequestParam("verifyCode") String verifyCode) {

        User user= userService.findAll(username);
        //new SecureRandomNumberGenerator().nextBytes().toHex()随机盐
        //获取的验证码转为大写
        String verifyCodeUp1=verifyCode.toUpperCase();
        String verifyCodes=(String) session.getAttribute("VerifyCode");
        String verifyCodeUp2=verifyCodes.toUpperCase();

        Md5Hash pws = new Md5Hash(password, user.getSalt(), 3);
      if(user==null){
          return new JsonToken(2,"账号或密码错误",0,0);
        }else{
          System.out.println(pws+"---"+user.getPassword());

          if(user.getUsername().equals(username)){
              System.out.println(pws+"---1111"+user.getPassword());
              if(user.getPassword().equals(String.valueOf(pws))){
                  System.out.println(pws+"---1111222"+user.getPassword());
                  if(verifyCodeUp1.equals(verifyCodeUp2)){
                      session.setAttribute("user",user);
                      return new JsonToken(0,"登录成功",0,0);
                  }
                  return new JsonToken(3,"验证码输入错误",0,0);
              }else{
                  return new JsonToken(1,"密码错误",0,0);
              }
          }

      }
        return new JsonToken(0,"登录成功",user,0);
    }

    @RequestMapping("/out")
    public String scoreQuery(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/";
    }
}





