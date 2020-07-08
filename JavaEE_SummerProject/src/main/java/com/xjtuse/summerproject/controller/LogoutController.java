package com.xjtuse.summerproject.controller;

import com.xjtuse.summerproject.controllerEntity.Info;
import com.xjtuse.summerproject.controllerEntity.ResponseInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {

    @RequestMapping("/Logout")
    public @ResponseBody
    ResponseInfo logout(@RequestBody Info info, HttpSession session) {
        session.removeAttribute("role");
        session.removeAttribute("username");
        session.removeAttribute("id");
        session.removeAttribute("email");
        session.removeAttribute("name");
        ResponseInfo responseInfo = new ResponseInfo();
        responseInfo.setSuccess_value("1");
        responseInfo.setFail_content("成功登出");
        return responseInfo;
    }
}
