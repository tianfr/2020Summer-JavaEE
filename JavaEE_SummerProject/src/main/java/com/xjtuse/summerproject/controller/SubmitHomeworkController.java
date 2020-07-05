package com.xjtuse.summerproject.controller;

import com.xjtuse.summerproject.entity.SubmitHomeworkInfo;
import com.xjtuse.summerproject.entity.SubmitHomeworkResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SubmitHomeworkController {
    @RequestMapping("/SubmitHomework")
    public @ResponseBody
    SubmitHomeworkResponse submitHomework(@RequestBody SubmitHomeworkInfo submitHomeworkInfo) {
        SubmitHomeworkResponse submitHomeworkResponse = new SubmitHomeworkResponse();
        submitHomeworkResponse.setSuccess_value("1");
        submitHomeworkResponse.setDatetime("2020-7-5");
        submitHomeworkResponse.setFail_content("上传出错");
        return submitHomeworkResponse;
    }
}
