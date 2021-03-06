package com.qssy.exam.webexam.controller;

import com.qssy.exam.webexam.service.IVerifyCodeGen;
import com.qssy.exam.webexam.service.impl.SimpleCharVerifyCodeGenImpl;
import com.qssy.exam.webexam.commom.VerifyCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class VerifyCodeController {

   /* @ApiOperation(value = "验证码")*/
    @GetMapping("/verifyCode")
    public void verifyCodea(HttpServletRequest request, HttpServletResponse response) {
        IVerifyCodeGen iVerifyCodeGen = new SimpleCharVerifyCodeGenImpl();
        try {
//设置长宽
            VerifyCode verifyCode = iVerifyCodeGen.generate(80, 28);
            String code = verifyCode.getCode();
         /*   LOGGER.info(code);*/
//将VerifyCode绑定session
            request.getSession().setAttribute("VerifyCode", code);
//设置响应头
            response.setHeader("Pragma", "no-cache");
//设置响应头
            response.setHeader("Cache-Control", "no-cache");
//在代理服务器端防止缓冲
            response.setDateHeader("Expires", 0);
//设置响应内容类型
            response.setContentType("image/jpeg");
            response.getOutputStream().write(verifyCode.getImgBytes());
            response.getOutputStream().flush();
        } catch (IOException e) {
           /* LOGGER.info("", e);*/
        }
    }
}
