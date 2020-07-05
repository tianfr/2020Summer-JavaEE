package com.xjtuse.summerproject.controller;

import com.xjtuse.summerproject.entity.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UpcomingIssueController {
    @RequestMapping("/UpcomingIssue")
    public @ResponseBody
    UpcomingIssueResponse upcomingIssue(@RequestBody Info info) {
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
        issue1.setContent("Title1");
        Issue issue2 = new Issue();
        issue2.setId("issue_id2");
        issue2.setValue("This is issue_id2");
        issue2.setIssue_id_path("This is issue_id_path2");
        issue2.setCourse("数字逻辑");
        issue2.setDeadline("2020-7-3");
        issue2.setStatus("expired");
        issue2.setContent("Title2");
        List<Issue> list = new ArrayList<Issue>();
        list.add(issue1);
        list.add(issue2);
        upcomingIssueResponse.setValue(list);
        return upcomingIssueResponse;
    }
}