package com.xjtuse.summerproject.controller;

import com.xjtuse.summerproject.entity.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DashBoardMenuController {
    @RequestMapping("/DashBoardMenu")
    public @ResponseBody DashBoardMenuResponse login(@RequestBody DashBoardMenuInfo dashBoardMenuInfo) {
        DashBoardMenuResponse dashBoardMenuResponse = new DashBoardMenuResponse();
        System.out.println("dashBoardMenuInfo = " + dashBoardMenuInfo);
        //模拟查数据库
        dashBoardMenuResponse.setAvater("This is an avatar_path");
        dashBoardMenuResponse.setUser_name("cdh");
        Course course1 = new Course();
        Course course2 = new Course();
        course1.setId("course1");
        course2.setId("course2");
        course1.setCourse_name("编译原理");
        course2.setCourse_name("计算机网络");
        course1.setCourse_path("This is course1's path");
        course2.setCourse_path("This is course2's path");
        List<Course> list = null;
        list.add(course1);
        list.add(course2);
        dashBoardMenuResponse.setValue(list);
        return dashBoardMenuResponse;
    }
}
