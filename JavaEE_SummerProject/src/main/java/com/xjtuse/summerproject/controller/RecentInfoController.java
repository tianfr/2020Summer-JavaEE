package com.xjtuse.summerproject.controller;

import com.xjtuse.summerproject.controllerEntity.Info;
import com.xjtuse.summerproject.controllerEntity.Issue;
import com.xjtuse.summerproject.controllerEntity.RecentInfo;
import com.xjtuse.summerproject.controllerEntity.RecentInfoResponse;
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
import java.net.HttpCookie;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RecentInfoController {

    @RequestMapping("/RecentInfo")
    public @ResponseBody
    RecentInfoResponse recentInfo(@RequestBody Info info, HttpSession session) throws IOException {
        RecentInfoResponse recentInfoResponse = new RecentInfoResponse();
        System.out.println("info = " + info);

        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession();

        String onlineRole = (String) session.getAttribute("role");
        String onId = (String) session.getAttribute("id");
        List<Course> courses = null;
        if (onlineRole == "student"){
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            courses = studentMapper.findAllCourseById(onId);
        }
        else {
            TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
            courses = teacherMapper.findAllCourseById(onId);
        }

//        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
//        List<Course> courses = studentMapper.findAllCourseById((String) session.getAttribute("id"));
        //  sqlSession.commit();
        List<RecentInfo> list = new ArrayList<RecentInfo>();
        for(Course course : courses) {
            List<CourseContent> courseContents = courseMapper.findRecentInfo(course.getCourse_content_table());
            for(CourseContent courseContent : courseContents) {
                System.out.println("courseContent = " + courseContent);
                RecentInfo recentInfo = new RecentInfo();
                recentInfo.setId(courseContent.getIssue_id());
                recentInfo.setValue(courseContent.getIssue_id());
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
                recentInfo.setInfo_id_path(tmp_id_path);
                recentInfo.setCourse(course.getCourse_name());
                recentInfo.setDatetime(courseContent.getInsert_date().toString());
                recentInfo.setContent(courseContent.getIssue_content());
                list.add(recentInfo);
            }
        }
        sqlSession.close();
        in.close();
        recentInfoResponse.setId("recent_info");
        recentInfoResponse.setValue(list);
        return recentInfoResponse;
    }
}
