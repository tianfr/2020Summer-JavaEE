package com.xjtuse.summerproject.controller;

import com.xjtuse.summerproject.controllerEntity.Attachment;
import com.xjtuse.summerproject.controllerEntity.GetHomeworkInfo;
import com.xjtuse.summerproject.controllerEntity.GetHomeworkResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GetHomeworkController {

    @RequestMapping("/GetHomework")
    public @ResponseBody
    GetHomeworkResponse getHomework(@RequestBody GetHomeworkInfo getHomeworkInfo) {
        System.out.println("ok");
        GetHomeworkResponse getHomeworkResponse = new GetHomeworkResponse();
        getHomeworkResponse.setDeadline("2020/07/20 12:30");
        getHomeworkResponse.setDatetime("2020/07/02 12:30");
        getHomeworkResponse.setHomework_title("这是标题");
        getHomeworkResponse.setAuthor("田暄");
        getHomeworkResponse.setAuthor_email("tianxuan@qq.com");
        getHomeworkResponse.setAuthor_avatar("img/dxz.jpg");
        getHomeworkResponse.setHomework_content("这是内容");
        List<Attachment> list = new ArrayList<Attachment>();
        Attachment attachment1 = new Attachment();
        Attachment attachment2 = new Attachment();
        attachment1.setAttachment_name("附件1");
        attachment1.setAttachment_path("test.html");
        attachment2.setAttachment_name("附件2");
        attachment2.setAttachment_path("test.html");
        list.add(attachment1);
        list.add(attachment2);
        getHomeworkResponse.setHomework_attachment(list);
        return getHomeworkResponse;
    }
}
