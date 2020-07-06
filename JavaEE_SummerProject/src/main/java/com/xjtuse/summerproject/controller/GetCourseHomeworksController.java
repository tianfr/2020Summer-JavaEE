package com.xjtuse.summerproject.controller;

import com.xjtuse.summerproject.controllerEntity.CourseHomework;
import com.xjtuse.summerproject.controllerEntity.GetCourseXXXsInfo;
import com.xjtuse.summerproject.controllerEntity.GetCourseXXXsResponse;
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
        Integer num_of_total_homeworks = 12;
        getCourseHomeworksResponse.setTotal_num(num_of_total_homeworks);
        String homework_title1 = "作业1";
        String homework_id1 = "homework_id1";
        String homework_content1 = "homework_content1";
        String homework_deadline1 = "2020-7-13";
        String homework_title2 = "作业2";
        String homework_id2 = "homework_id2";
        String homework_content2 = "这是homework_content2";
        String homework_deadline2 = "2020-7-14";
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
        String homework_title3 = "作业3";
        String homework_id3 = "homework_id3";
        String homework_content3 = "homework_content3";
        String homework_deadline3 = "2020-7-23";
        String homework_title4 = "作业4";
        String homework_id4 = "homework_id4";
        String homework_content4 = "这是homework_content4";
        String homework_deadline4 = "2020-7-24";
        CourseHomework courseHomework3 = new CourseHomework();
        CourseHomework courseHomework4 = new CourseHomework();
        courseHomework3.setHomework_title(homework_title3);
        courseHomework3.setHomework_id(homework_id3);
        courseHomework3.setHomework_content(homework_content3);
        courseHomework3.setHomework_deadline(homework_deadline3);
        courseHomework4.setHomework_title(homework_title4);
        courseHomework4.setHomework_id(homework_id4);
        courseHomework4.setHomework_content(homework_content4);
        courseHomework4.setHomework_deadline(homework_deadline4);
        String homework_title5 = "作业5";
        String homework_id5 = "homework_id5";
        String homework_content5 = "homework_content5";
        String homework_deadline5 = "2020-8-13";
        String homework_title6 = "作业6";
        String homework_id6 = "homework_id6";
        String homework_content6 = "这是homework_content6";
        String homework_deadline6 = "2020-8-14";
        CourseHomework courseHomework5 = new CourseHomework();
        CourseHomework courseHomework6 = new CourseHomework();
        courseHomework5.setHomework_title(homework_title5);
        courseHomework5.setHomework_id(homework_id5);
        courseHomework5.setHomework_content(homework_content5);
        courseHomework5.setHomework_deadline(homework_deadline5);
        courseHomework6.setHomework_title(homework_title6);
        courseHomework6.setHomework_id(homework_id6);
        courseHomework6.setHomework_content(homework_content6);
        courseHomework6.setHomework_deadline(homework_deadline6);
        List<Object> list = new ArrayList();
        list.add(courseHomework1);
        list.add(courseHomework1);
        list.add(courseHomework1);
        list.add(courseHomework1);
        list.add(courseHomework1);
        list.add(courseHomework1);
        list.add(courseHomework1);
        list.add(courseHomework2);
        list.add(courseHomework3);
        list.add(courseHomework4);
        list.add(courseHomework5);
        list.add(courseHomework6);
        getCourseHomeworksResponse.setValue(list);
        return getCourseHomeworksResponse;
    }
}
