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
        GetHomeworkResponse getHomeworkResponse = new GetHomeworkResponse();
        getHomeworkResponse.setHomework_title("这是标题");
        getHomeworkResponse.setAuthor("田暄");
        getHomeworkResponse.setAuthor_email("tianxuan@qq.com");
        getHomeworkResponse.setAuthor_avatar("这是头像路径");
        getHomeworkResponse.setHomework_content("这是内容");
        List<Attachment> list = new ArrayList<Attachment>();
        Attachment attachment1 = new Attachment();
        Attachment attachment2 = new Attachment();
        attachment1.setAttachment_name("附件1");
        attachment1.setAttachment_path("附件1的路径");
        attachment2.setAttachment_name("附件2");
        attachment2.setAttachment_path("附件2的路径");
        list.add(attachment1);
        list.add(attachment2);
        getHomeworkResponse.setHomework_attachment(list);
        return getHomeworkResponse;
    }
}
