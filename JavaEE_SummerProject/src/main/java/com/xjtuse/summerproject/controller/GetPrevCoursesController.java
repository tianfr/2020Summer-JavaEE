package com.xjtuse.summerproject.controller;

import com.xjtuse.summerproject.controllerEntity.GetPrevCoursesInfo;
import com.xjtuse.summerproject.controllerEntity.GetPrevCoursesResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GetPrevCoursesController {
    // 6.17 接口
    @RequestMapping("/GetPrevCourses")
    public @ResponseBody
    GetPrevCoursesResponse getPrevCoursesResponse(@RequestBody GetPrevCoursesInfo getPrevCoursesInfo){

    }

}
