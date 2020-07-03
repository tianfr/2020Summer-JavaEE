package com.xjtuse.summerproject.controller;

import com.xjtuse.summerproject.entity.PasswordReminderInfo;
import com.xjtuse.summerproject.entity.ResponseInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PasswordReminderController {

    @RequestMapping("/PasswordReminder")
    public @ResponseBody ResponseInfo passwordReminder(@RequestBody PasswordReminderInfo passwordReminderInfo) {
        ResponseInfo responseInfo = new ResponseInfo();
        if(true) {
            System.out.println("ok");
            responseInfo.setSuccess_value("1");
            responseInfo.setFail_content("成功");
        }
        else {
            responseInfo.setSuccess_value("0");
            responseInfo.setFail_content("邮箱不存在");
        }
        return responseInfo;
    }
}
