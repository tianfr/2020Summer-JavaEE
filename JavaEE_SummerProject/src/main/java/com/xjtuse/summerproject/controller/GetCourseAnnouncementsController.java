package com.xjtuse.summerproject.controller;

import com.xjtuse.summerproject.controllerEntity.CourseAnnouncement;
import com.xjtuse.summerproject.controllerEntity.GetCourseXXXsInfo;
import com.xjtuse.summerproject.controllerEntity.GetCourseXXXsResponse;
import com.xjtuse.summerproject.entity.Course;
import com.xjtuse.summerproject.entity.CourseContent;
import com.xjtuse.summerproject.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GetCourseAnnouncementsController {

    @RequestMapping(value = "/GetCourseAnnouncements", method = RequestMethod.POST)
    public @ResponseBody
    GetCourseXXXsResponse getCourseAnnouncements(@RequestBody GetCourseXXXsInfo getCourseAnnouncementsInfo) throws IOException {
        GetCourseXXXsResponse getCourseAnnouncementsResponse = new GetCourseXXXsResponse();
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<CourseContent> courseContents = studentMapper.getCourseAnnouncements(getCourseAnnouncementsInfo.getCourse_id());
        sqlSession.close();
        in.close();
        List<Object> list = new ArrayList();
        getCourseAnnouncementsResponse.setId("course_announcement");
        getCourseAnnouncementsResponse.setTotal_num(0);
        for(CourseContent courseContent : courseContents) {
            getCourseAnnouncementsResponse.setTotal_num(getCourseAnnouncementsResponse.getTotal_num()+1);
            CourseAnnouncement courseAnnouncement = new CourseAnnouncement();
            courseAnnouncement.setAnnouncement_id(courseContent.getIssue_id());
            courseAnnouncement.setAnnouncement_content(courseContent.getIssue_content());
            courseAnnouncement.setAnnouncement_title(courseContent.getIssue_title());
            list.add(courseAnnouncement);
        }
        getCourseAnnouncementsResponse.setValue(list);
        System.out.println("getCourseAnnouncementsResponse = " + getCourseAnnouncementsResponse);
        return getCourseAnnouncementsResponse;
    }
}
