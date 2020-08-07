package com.qssy.exam.webexam.controller;

import com.qssy.exam.webexam.commom.JsonToken;
import com.qssy.exam.webexam.entity.User;
import com.qssy.exam.webexam.service.UserService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * @author zzz
 */
@Controller
public class RegistController {

    @Autowired
    private UserService userService;


    @GetMapping("/regist")
    public String login() {
        return "account/regist";
    }

   @PostMapping("regists")
    @ResponseBody
    public JsonToken toRegists(@RequestParam("username") String username, @RequestParam("password") String password) {

       //自动生成主键uuid并去掉“-”
       String id = UUID.randomUUID().toString().replaceAll("-", "");

        User user= userService.findAll(username);
        User user1=new User();
        if(user==null){
            user1.setId(id);
            user1.setUsername(username);
            user1.setSalt(String.valueOf(new SecureRandomNumberGenerator().nextBytes().toHex()));
            user1.setPassword(String.valueOf(new Md5Hash(password, user1.getSalt(), 3)));
            int user2 = userService.addUser(user1);
            return new JsonToken(200, "注册账号成功", user1.getPassword(), 0);
        }else {
            return new JsonToken(0,"此账号已被注册",0,0);
        }
    }
}





