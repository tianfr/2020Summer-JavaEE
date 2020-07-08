package com.xjtuse.summerproject.controller;

import com.xjtuse.summerproject.controllerEntity.Announcement;
import com.xjtuse.summerproject.controllerEntity.GetAnnouncementInfo;
import com.xjtuse.summerproject.entity.CourseContent;
import com.xjtuse.summerproject.entity.SendAnnouncement;
import com.xjtuse.summerproject.entity.Teacher;
import com.xjtuse.summerproject.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
public class GetAnnouncementController {

    @RequestMapping("/GetAnnouncement")
    public @ResponseBody
    Announcement getAnnouncement(@RequestBody GetAnnouncementInfo getAnnouncementInfo) throws IOException {
        Announcement announcement = new Announcement();
        //1.读取配置文件，生成字节输入流
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //4.使用SqlSession创建Mapper接口的代理对象
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        SendAnnouncement sendAnnouncement = new SendAnnouncement();
        sendAnnouncement.setCourse_id(getAnnouncementInfo.getCourse_id());
        sendAnnouncement.setAnnouncement_id(getAnnouncementInfo.getAnnouncement_id());
        CourseContent courseContent = studentMapper.getAnnouncement(sendAnnouncement);
        System.out.println("courseContent = " + courseContent);
        Teacher teacher = studentMapper.getAnnouncementTeacher(getAnnouncementInfo.getAnnouncement_id().substring(0, 11));
        System.out.println("teacher = " + teacher);
        //提交事务
//        sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        in.close();
        announcement.setAnnouncement_title(courseContent.getIssue_title());
        announcement.setAuthor(teacher.getTeacher_name());
        announcement.setAuthor_email(teacher.getTeacher_email());
        announcement.setAuthor_avatar(teacher.getTeacher_avatar());
        announcement.setAnnouncement_content(courseContent.getIssue_content());
        announcement.setDatetime(courseContent.getInsert_date().toString());
        System.out.println("announcement = " + announcement);
        return announcement;
    }
}
