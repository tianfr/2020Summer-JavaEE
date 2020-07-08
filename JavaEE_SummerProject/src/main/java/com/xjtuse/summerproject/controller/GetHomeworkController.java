package com.xjtuse.summerproject.controller;

import com.xjtuse.summerproject.controllerEntity.Attachment;
import com.xjtuse.summerproject.controllerEntity.GetHomeworkInfo;
import com.xjtuse.summerproject.controllerEntity.GetHomeworkResponse;
import com.xjtuse.summerproject.entity.CourseContent;
import com.xjtuse.summerproject.entity.SendAnnouncement;
import com.xjtuse.summerproject.entity.SendHomework;
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
import java.util.ArrayList;
import java.util.List;

@Controller
public class GetHomeworkController {

    @RequestMapping("/GetHomework")
    public @ResponseBody
    GetHomeworkResponse getHomework(@RequestBody GetHomeworkInfo getHomeworkInfo) throws IOException {
        GetHomeworkResponse getHomeworkResponse = new GetHomeworkResponse();

        //1.读取配置文件，生成字节输入流
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //4.使用SqlSession创建Mapper接口的代理对象
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        SendHomework sendHomework = new SendHomework();
        sendHomework.setCourse_id(getHomeworkInfo.getCourse_id());
        sendHomework.setHomework_id(getHomeworkInfo.getHomework_id());
        CourseContent courseContent = studentMapper.getHomework(sendHomework);
        System.out.println("courseContent = " + courseContent);
        Teacher teacher = studentMapper.getHomeworkTeacher(getHomeworkInfo.getHomework_id().substring(0, 11));
        System.out.println("teacher = " + teacher);
        //提交事务
//        sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        in.close();

        getHomeworkResponse.setDeadline(courseContent.getIssue_deadline().toString());
        getHomeworkResponse.setDatetime(courseContent.getInsert_date().toString());
        getHomeworkResponse.setHomework_title(courseContent.getIssue_title());
        getHomeworkResponse.setAuthor(teacher.getTeacher_name());
        getHomeworkResponse.setAuthor_email(teacher.getTeacher_email());
        getHomeworkResponse.setAuthor_avatar(teacher.getTeacher_avatar());
        getHomeworkResponse.setHomework_content(courseContent.getIssue_content());
        List<Attachment> list = new ArrayList<Attachment>();
        int l = courseContent.getIssue_attachment_path().split(";").length;
        for(int i = 0; i < l; i++) {
            Attachment attachment = new Attachment();
            attachment.setAttachment_name(courseContent.getIssue_attachment_name().split(";")[i]);
            attachment.setAttachment_path(courseContent.getIssue_attachment_path().split(";")[i]);
            list.add(attachment);
        }
        getHomeworkResponse.setHomework_attachment(list);
        return getHomeworkResponse;
    }
}
