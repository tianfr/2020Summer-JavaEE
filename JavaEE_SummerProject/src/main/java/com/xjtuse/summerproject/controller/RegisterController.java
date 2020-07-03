package com.xjtuse.summerproject.controller;

import com.xjtuse.summerproject.entity.RegisterInfo;
import com.xjtuse.summerproject.entity.ResponseInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegisterController {
    @RequestMapping("/Register")
    public @ResponseBody ResponseInfo register(@RequestBody RegisterInfo registerInfo) {
        ResponseInfo responseInfo = new ResponseInfo();
        System.out.println("registerInfo = " + registerInfo);
        if(false) { //用户名已存在
            responseInfo.setSuccess_value("0");
            responseInfo.setFail_content("用户名已存在");
        }
        else {
            /*
            * 将新用户写入数据库，并把id反馈给用户
            * */
            responseInfo.setSuccess_value("1");
            String id = "123456";
            responseInfo.setFail_content("注册成功，id是" + id);
        }
        return responseInfo;
    }
}
