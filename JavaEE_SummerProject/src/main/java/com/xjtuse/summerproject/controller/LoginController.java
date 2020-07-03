package com.xjtuse.summerproject.controller;

import com.xjtuse.summerproject.entity.LoginInfo;
import com.xjtuse.summerproject.entity.ResponseInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    @RequestMapping("/Login")
    public @ResponseBody
    ResponseInfo login(@RequestBody LoginInfo loginInfo) {
        ResponseInfo responseInfo = new ResponseInfo();
        System.out.println("loginInfo = " + loginInfo);
        if(loginInfo.getUser_name().equals("cdh") && loginInfo.getPass_word().equals("123")) {//判断用户名密码是否正确
            responseInfo.setSuccess_value("1");
            responseInfo.setFail_content("成功");
        }
        else if(true){ //密码错误
            responseInfo.setSuccess_value("0");
            responseInfo.setFail_content("密码错误");
        }
        else {  //用户名不存在
            responseInfo.setSuccess_value("0");
            responseInfo.setFail_content("用户名不存在");
        }
        return responseInfo;
    }
}
