package com.xjtuse.controller;

import com.xjtuse.entity.LoginInfo;
import com.xjtuse.entity.LoginResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    @RequestMapping("/login")
    public @ResponseBody LoginResponse login(@RequestBody LoginInfo loginInfo) {
        System.out.println("login方法执行了");
        System.out.println("loginInfo = " + loginInfo);
        LoginResponse loginResponse = new LoginResponse();
        System.out.println(loginInfo.getContent().get(0).getValue());
        System.out.println(loginInfo.getContent().get(1).getValue());
        if(loginInfo.getContent().get(0).getValue().equals("cdh") && loginInfo.getContent().get(1).getValue().equals("123")) {//判断用户名密码是否正确
            loginResponse.setSuccessvalue("1");
            loginResponse.setFailcontent("成功");
            System.out.println("loginResponse = " + loginResponse);
            return loginResponse;
        }
        else {
            loginResponse.setSuccessvalue("0");
            loginResponse.setFailcontent("失败");
            System.out.println("loginResponse = " + loginResponse);
            return loginResponse;
        }
    }
}
