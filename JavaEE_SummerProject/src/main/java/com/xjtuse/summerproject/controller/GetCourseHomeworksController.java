package com.xjtuse.summerproject.controller;

import com.xjtuse.summerproject.entity.CourseHomework;
import com.xjtuse.summerproject.entity.GetCourseXXXsInfo;
import com.xjtuse.summerproject.entity.GetCourseXXXsResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GetCourseHomeworksController {

    @RequestMapping("/GetCourseHomeworks")
    public @ResponseBody
    GetCourseXXXsResponse getCourseHomeworks(@RequestBody GetCourseXXXsInfo getCourseXXXsInfo) {
        GetCourseXXXsResponse getCourseHomeworksResponse = new GetCourseXXXsResponse();
        getCourseHomeworksResponse.setId("course_homeworks");
        Integer num_of_total_homeworks = 2;
        getCourseHomeworksResponse.setTotal_num(num_of_total_homeworks);
        String homework_title1 = "作业1";
        String homework_id1 = "这是homework_id1";
        String homework_content1 = "这是homework_content1";
        String homework_deadline1 = "这是homework_deadline1";
        String homework_title2 = "作业2";
        String homework_id2 = "这是homework_id2";
        String homework_content2 = "这是homework_content2";
        String homework_deadline2 = "这是homework_deadline2";
        CourseHomework courseHomework1 = new CourseHomework();
        CourseHomework courseHomework2 = new CourseHomework();
        courseHomework1.setHomework_title(homework_title1);
        courseHomework1.setHomework_id(homework_id1);
        courseHomework1.setHomework_content(homework_content1);
        courseHomework1.setHomework_deadline(homework_deadline1);
        courseHomework2.setHomework_title(homework_title2);
        courseHomework2.setHomework_id(homework_id2);
        courseHomework2.setHomework_content(homework_content2);
        courseHomework2.setHomework_deadline(homework_deadline2);
        List<Object> list = new ArrayList();
        list.add(courseHomework1);
        list.add(courseHomework2);
        getCourseHomeworksResponse.setValue(list);
        return getCourseHomeworksResponse;
    }
}
