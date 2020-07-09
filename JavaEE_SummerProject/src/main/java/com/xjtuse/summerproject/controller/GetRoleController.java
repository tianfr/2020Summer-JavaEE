package com.xjtuse.summerproject.controller;

import com.xjtuse.summerproject.controllerEntity.Info;
import com.xjtuse.summerproject.controllerEntity.ResponseInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class GetRoleController {
    @RequestMapping("/GetRole")
    public @ResponseBody
    ResponseInfo getRole(@RequestBody Info info, HttpSession session) {
        ResponseInfo responseInfo = new ResponseInfo();
        responseInfo.setRole(session.getAttribute("role").toString());
        return responseInfo;
    }
}
