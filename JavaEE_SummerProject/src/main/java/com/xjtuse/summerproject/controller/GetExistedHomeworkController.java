package com.xjtuse.summerproject.controller;

import com.xjtuse.summerproject.controllerEntity.File;
import com.xjtuse.summerproject.controllerEntity.GetExistedHomeworkInfo;
import com.xjtuse.summerproject.controllerEntity.GetExistedHomeworkResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GetExistedHomeworkController {
    @RequestMapping("/GetExistedHomework")
    public @ResponseBody
    GetExistedHomeworkResponse getExistedHomework(@RequestBody GetExistedHomeworkInfo getExistedHomeworkInfo) {
        GetExistedHomeworkResponse getExistedHomeworkResponse = new GetExistedHomeworkResponse();
        getExistedHomeworkResponse.setHomework_status("drafted");
        getExistedHomeworkResponse.setHomework_content("<div>Homework_content</div>");
        getExistedHomeworkResponse.setSubmitted_time("2020-6-3");
        getExistedHomeworkResponse.setHomework_deadline("2020-8-10");
        getExistedHomeworkResponse.setHave_attachments("no");
        File file1 = new File();
        File file2 = new File();
        file1.setFile_name("file1");
        file1.setFile_path("test.html");
        file2.setFile_name("file2");
        file2.setFile_path("test.html");
        List<File> list = new ArrayList<File>();
        list.add(file1);
        list.add(file2);
        getExistedHomeworkResponse.setHomework_attachments(list);
        return getExistedHomeworkResponse;
    }
}
