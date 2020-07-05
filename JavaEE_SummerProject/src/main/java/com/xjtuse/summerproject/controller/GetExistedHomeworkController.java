package com.xjtuse.summerproject.controller;

import com.xjtuse.summerproject.entity.File;
import com.xjtuse.summerproject.entity.GetExistedHomeworkInfo;
import com.xjtuse.summerproject.entity.GetExistedHomeworkResponse;
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
        getExistedHomeworkResponse.setHomework_status("submitted");
        getExistedHomeworkResponse.setHomework_content("Homework_content");
        getExistedHomeworkResponse.setSubmitted_time("2020-7-3");
        getExistedHomeworkResponse.setHomework_deadline("2020-7-10");
        getExistedHomeworkResponse.setHave_attachments("yes");
        File file1 = new File();
        File file2 = new File();
        file1.setFile_name("file1");
        file1.setFile_path("xxx");
        file2.setFile_name("file2");
        file2.setFile_path("xxx");
        List<File> list = new ArrayList<File>();
        list.add(file1);
        list.add(file2);
        getExistedHomeworkResponse.setHomework_attachments(list);
        return getExistedHomeworkResponse;
    }
}
