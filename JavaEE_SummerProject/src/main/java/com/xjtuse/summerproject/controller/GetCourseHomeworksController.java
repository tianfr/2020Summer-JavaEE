package com.xjtuse.summerproject.controller;

import com.xjtuse.summerproject.controllerEntity.CourseHomework;
import com.xjtuse.summerproject.controllerEntity.GetCourseXXXsInfo;
import com.xjtuse.summerproject.controllerEntity.GetCourseXXXsResponse;
import com.xjtuse.summerproject.entity.CourseContent;
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
public class GetCourseHomeworksController {

    @RequestMapping("/GetCourseHomeworks")
    public @ResponseBody
    GetCourseXXXsResponse getCourseHomeworks(@RequestBody GetCourseXXXsInfo getCourseXXXsInfo) throws IOException {
        GetCourseXXXsResponse getCourseHomeworksResponse = new GetCourseXXXsResponse();
        getCourseHomeworksResponse.setId("course_homeworks");
        getCourseHomeworksResponse.setTotal_num(0);
        //1.读取配置文件，生成字节输入流
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //4.使用SqlSession创建Mapper接口的代理对象
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<CourseContent> courseContents = studentMapper.getCourseHomeworks(getCourseXXXsInfo.getCourse_id().substring(6));
        //提交事务
//        sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        in.close();
        List<Object> list = new ArrayList();
        for(CourseContent courseContent : courseContents) {
            getCourseHomeworksResponse.setTotal_num(getCourseHomeworksResponse.getTotal_num()+1);
            CourseHomework courseHomework = new CourseHomework();
            courseHomework.setHomework_content(courseContent.getIssue_content());
            courseHomework.setHomework_deadline(courseContent.getIssue_deadline().toString());
            System.out.println("courseHomework.getHomework_deadline() = " + courseHomework.getHomework_deadline());
            courseHomework.setHomework_id(courseContent.getIssue_id());
            courseHomework.setHomework_title(courseContent.getIssue_title());
            list.add(courseHomework);
        }
        getCourseHomeworksResponse.setValue(list);
        return getCourseHomeworksResponse;
    }
}
