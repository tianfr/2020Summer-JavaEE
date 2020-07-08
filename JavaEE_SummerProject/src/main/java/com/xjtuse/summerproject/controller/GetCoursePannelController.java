package com.xjtuse.summerproject.controller;

import com.xjtuse.summerproject.controllerEntity.*;
import com.xjtuse.summerproject.mapper.CourseMapper;
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
public class GetCoursePannelController {

    @RequestMapping("/GetCoursePanel")
    public @ResponseBody
    GetCoursePanelResponse getCoursePanel(@RequestBody GetCoursePanelInfo getCoursePanelInfo) throws IOException {
        GetCoursePanelResponse getCoursePanelResponse = new GetCoursePanelResponse();
        //模拟查数据库
        String courseid = getCoursePanelInfo.getCourse_id();



        CourseMapper courseMapper;
        //1.读取配置文件，生成字节输入流
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //4.使用SqlSession创建Mapper接口的代理对象
        courseMapper = sqlSession.getMapper(CourseMapper.class);
        List<com.xjtuse.summerproject.entity.CoursePanel> coursePanels = courseMapper.getCoursePanel(courseid);
        //提交事务
//        sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        in.close();

        getCoursePanelResponse.setId("course_panel");
        List<CoursePanel> list = new ArrayList<CoursePanel>();
        for (com.xjtuse.summerproject.entity.CoursePanel coursePanel : coursePanels) {
            CoursePanel coursePanel1 = new CoursePanel();
            coursePanel1.setPanel_id(coursePanel.getDesign_id());
            coursePanel1.setPanel_name(coursePanel.getDesign_name());
            list.add(coursePanel1);
        }
        getCoursePanelResponse.setValue(list);
        System.out.println("getCoursePanelResponse = " + getCoursePanelResponse);
        return getCoursePanelResponse;
    }
}
