package com.xjtuse.summerproject.controller;

import com.xjtuse.summerproject.entity.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GetCoursePannelController {

    @RequestMapping("/GetCoursePanel")
    public @ResponseBody
    GetCoursePanelResponse getCoursePanel(@RequestBody GetCoursePanelInfo getCoursePanelInfo) {
        GetCoursePanelResponse getCoursePanelResponse = new GetCoursePanelResponse();
        System.out.println("getCoursePanelInfo = " + getCoursePanelInfo);
        //模拟查数据库
        String courseid = getCoursePanelInfo.getCourse_id();
        System.out.println("courseid = " + courseid);
        getCoursePanelResponse.setId("course_panel");
        CoursePanel coursePanel1 = new CoursePanel();
        CoursePanel coursePanel2 = new CoursePanel();
        coursePanel1.setPanel_id("panel_id1");
        coursePanel2.setPanel_id("panel_id2");
        coursePanel1.setPanel_name("panel_name1");
        coursePanel2.setPanel_name("panel_name2");
        List<CoursePanel> list = new ArrayList<CoursePanel>();
        list.add(coursePanel1);
        list.add(coursePanel2);
        getCoursePanelResponse.setValue(list);
        System.out.println("getCoursePanelResponse = " + getCoursePanelResponse);
        return getCoursePanelResponse;
    }
}
