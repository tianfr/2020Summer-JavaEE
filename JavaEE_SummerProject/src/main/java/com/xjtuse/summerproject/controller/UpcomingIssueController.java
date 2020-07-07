package com.xjtuse.summerproject.controller;

import com.xjtuse.summerproject.controllerEntity.*;
import com.xjtuse.summerproject.entity.Course;
import com.xjtuse.summerproject.entity.CourseContent;
import com.xjtuse.summerproject.mapper.CourseMapper;
import com.xjtuse.summerproject.mapper.StudentMapper;
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
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UpcomingIssueController {
    @RequestMapping("/UpcomingIssue")
    public @ResponseBody
    UpcomingIssueResponse upcomingIssue(@RequestBody Info info, HttpSession session) throws IOException {
        UpcomingIssueResponse upcomingIssueResponse = new UpcomingIssueResponse();
        System.out.println("Info = " + info);

        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
        List<Course> courses = studentMapper.findAllCourseById((String) session.getAttribute("id"));
        //  sqlSession.commit();
        List<Issue> list = new ArrayList<Issue>();
        for(Course course : courses) {
            List<CourseContent> courseContents = courseMapper.findUpcomingIssue(course.getCourse_content_table());
            for(CourseContent courseContent : courseContents) {
                System.out.println("courseContent = " + courseContent);
                Issue issue = new Issue();
                issue.setId(courseContent.getIssue_id());
                issue.setContent(courseContent.getIssue_content());
                issue.setDeadline(courseContent.getIssue_deadline());
                issue.setValue(courseContent.getIssue_id());
                issue.setIssue_id_path("test.html");
                if(true) {  //not submitted
                    Date date = new Date(System.currentTimeMillis());
                    if(courseContent.getIssue_deadline().compareTo(date) < 0) {
                        issue.setStatus("expired");
                    }
                    else {
                        issue.setStatus("on_schedule");
                    }
                }
                else {
                    issue.setStatus("submitted");
                }
                issue.setCourse(course.getCourse_name());
                list.add(issue);
            }
        }
        sqlSession.close();
        in.close();
        upcomingIssueResponse.setId("issues");
        upcomingIssueResponse.setTotal_num(list.size());
        upcomingIssueResponse.setValue(list);
        return upcomingIssueResponse;
    }
}
