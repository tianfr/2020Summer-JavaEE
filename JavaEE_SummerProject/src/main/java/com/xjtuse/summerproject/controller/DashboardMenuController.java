package com.xjtuse.summerproject.controller;

import com.xjtuse.summerproject.controllerEntity.*;
import com.xjtuse.summerproject.mapper.StudentMapper;
import com.xjtuse.summerproject.mapper.TeacherMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DashboardMenuController {
    @RequestMapping("/DashboardMenu")
    public @ResponseBody
    DashboardMenuResponse dashBoardMenu(@RequestBody DashboardMenuInfo dashboardMenuInfo, HttpSession session) throws IOException {
        DashboardMenuResponse dashboardMenuResponse = new DashboardMenuResponse();
        System.out.println("session.getAttribute(\"id\") = " + session.getAttribute("id"));
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        List<com.xjtuse.summerproject.entity.Course> courses;
        if(session.getAttribute("role") == "student") {
            courses = studentMapper.findAllCourseById((String) session.getAttribute("id"));
        }
        else {
            courses = teacherMapper.findAllCourseById((String) session.getAttribute("id"));
        }
        sqlSession.close();
        in.close();
        dashboardMenuResponse.setAvater("This is an avatar_path");
        dashboardMenuResponse.setUser_name((String) session.getAttribute("name"));
        dashboardMenuResponse.setEmail((String) session.getAttribute("email"));
        List<Course> list = new ArrayList<Course>();
        for(com.xjtuse.summerproject.entity.Course course : courses ) {
            Course course1 = new Course();
            course1.setCourse_name(course.getCourse_name());
            course1.setId(course.getCourse_id());
            course1.setCourse_path("");
            list.add(course1);
        }
        dashboardMenuResponse.setValue(list);
        System.out.println("list = " + list);
        return dashboardMenuResponse;
    }
}
