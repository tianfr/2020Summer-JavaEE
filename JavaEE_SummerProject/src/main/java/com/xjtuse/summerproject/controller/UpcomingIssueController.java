package com.xjtuse.summerproject.controller;

import com.xjtuse.summerproject.entity.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UpcomingIssueController {
    @RequestMapping("/UpcomingIssue")
    public @ResponseBody
    UpcomingIssueResponse login(@RequestBody Info info) {
        UpcomingIssueResponse upcomingIssueResponse = new UpcomingIssueResponse();
        System.out.println("Info = " + info);
        //模拟查数据库
        upcomingIssueResponse.setId("issues");
        Issue issue1 = new Issue();
        issue1.setId("issue_id1");
        issue1.setValue("This is issue_id1");
        issue1.setIssue_id_path("This is issue_id_path1");
        issue1.setCourse("算法设计与分析");
        issue1.setDeadline("2020-7-10");
        issue1.setStatus("on_schedule");
        Issue issue2 = new Issue();
        issue1.setId("issue_id2");
        issue1.setValue("This is issue_id2");
        issue1.setIssue_id_path("This is issue_id_path2");
        issue1.setCourse("数字逻辑");
        issue1.setDeadline("2020-7-3");
        issue1.setStatus("expired");
        List<Issue> list = null;
        list.add(issue1);
        list.add(issue2);
        upcomingIssueResponse.setValue(list);
        return upcomingIssueResponse;
    }
}
