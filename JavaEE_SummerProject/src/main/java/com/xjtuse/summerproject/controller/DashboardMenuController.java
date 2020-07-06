package com.xjtuse.summerproject.controller;

import com.xjtuse.summerproject.controllerEntity.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DashboardMenuController {
    @RequestMapping("/DashboardMenu")
    public @ResponseBody
    DashboardMenuResponse dashBoardMenu(@RequestBody DashboardMenuInfo dashboardMenuInfo) {
        DashboardMenuResponse dashboardMenuResponse = new DashboardMenuResponse();
        System.out.println("dashBoardMenuInfo = " + dashboardMenuInfo);
        //模拟查数据库
        dashboardMenuResponse.setAvater("This is an avatar_path");
        dashboardMenuResponse.setUser_name("cdh");
        Course course1 = new Course();
        Course course2 = new Course();
        course1.setId("course1");
        course2.setId("course2");
        course1.setCourse_name("编译原理");
        course2.setCourse_name("计算机网络");
        course1.setCourse_path("This is course1's path");
        course2.setCourse_path("This is course2's path");
        List<Course> list = new ArrayList<Course>();
        list.add(course1);
        list.add(course2);
        dashboardMenuResponse.setValue(list);
        return dashboardMenuResponse;
    }
}
