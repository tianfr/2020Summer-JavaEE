package com.xjtuse.summerproject.controller;

import com.xjtuse.summerproject.controllerEntity.*;
import com.xjtuse.summerproject.entity.Course;
import com.xjtuse.summerproject.entity.CourseContent;
import com.xjtuse.summerproject.mapper.CourseMapper;
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
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UpcomingIssueController {
    @RequestMapping("/UpcomingIssue")
    public @ResponseBody
    UpcomingIssueResponse upcomingIssue(@RequestBody Info info, HttpSession session) throws IOException, ParseException {
        UpcomingIssueResponse upcomingIssueResponse = new UpcomingIssueResponse();
        upcomingIssueResponse.setTotal_num(0);
        System.out.println("Info = " + info);
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession();
        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
        String onlineRole = (String) session.getAttribute("role");
        String onId = (String) session.getAttribute("id");
        List<Course> courseList = new ArrayList<Course>();
        if (onlineRole.equals("student")){
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            courseList = studentMapper.findAllCourseById(onId);
        }
        else {
            TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
            courseList = teacherMapper.findAllCourseById(onId);
        }

        //  sqlSession.commit();
        List<Issue> list = new ArrayList<Issue>();
        for(Course course : courseList) {
            List<CourseContent> courseContents = courseMapper.findUpcomingIssue(course.getCourse_content_table());
            for(CourseContent courseContent : courseContents) {
                System.out.println("courseContent = " + courseContent);
                Issue issue = new Issue();
                issue.setId(courseContent.getIssue_id());
                issue.setContent(courseContent.getIssue_content());
                issue.setDeadline(courseContent.getIssue_deadline().toString());
//                System.out.println(courseContent.getIssue_deadline().toString());
                issue.setValue(courseContent.getIssue_id());
                String tmp_id_path = "";//""course-dashboard.html?cid=" + course.getCourse_id();
                switch (courseContent.getIssue_type()){
                    case "announcement":
                        tmp_id_path +=  ("announcement.html?cid=" + course.getCourse_id() + "&aid=" + courseContent.getIssue_id());
                        break;
                    case "homework":
                        tmp_id_path +=  ("homework-message.html?cid=" + course.getCourse_id() + "&hid=" + courseContent.getIssue_id());
                        break;
                    case "discussion":
                        tmp_id_path +=  ("discussion.html?cid=" + course.getCourse_id() + "&did=" + courseContent.getIssue_id());
                        break;
                    case "examination":
                        tmp_id_path +=  ("examination.html?cid=" + course.getCourse_id() + "&eid=" + courseContent.getIssue_id());
                        break;
                    default: tmp_id_path +=  ("&errorid=" + courseContent.getIssue_id()+"type:"+courseContent.getIssue_type());
                }
                // + "&aid=" + courseContent.getIssue_id();
                issue.setIssue_id_path(tmp_id_path);
                if(true) {  //not submitted
                    Date date = new Date(System.currentTimeMillis());
                    int minusDate = getDayDiffer(courseContent.getIssue_deadline(), date);
                    if(minusDate <= 0) {

                        if (-minusDate <= 2){

                            issue.setStatus("on_schedule_yellow");
                        }
                        else issue.setStatus("on_schedule");
                    }
                    else{
                        issue.setStatus("expired");
                    }

                }
                else {
                    issue.setStatus("submitted");
                }
                issue.setCourse(course.getCourse_name());
                list.add(issue);
                upcomingIssueResponse.setTotal_num(upcomingIssueResponse.getTotal_num()+1);
            }
        }
        sqlSession.close();
        in.close();
        upcomingIssueResponse.setId("issues");
        upcomingIssueResponse.setTotal_num(list.size());
        upcomingIssueResponse.setValue(list);
        return upcomingIssueResponse;
    }
    public static int getDayDiffer(Date startDate, Date endDate) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long startDateTime = dateFormat.parse(dateFormat.format(startDate)).getTime();
        long endDateTime = dateFormat.parse(dateFormat.format(endDate)).getTime();
        System.out.println((int) ((endDateTime - startDateTime) / (1000 * 3600 * 24)));
        return (int) ((endDateTime - startDateTime) / (1000 * 3600 * 24));
    }

}
