package com.xjtuse.summerproject.controller;

import com.xjtuse.summerproject.controllerEntity.GetStudentHomeworkDetailInfo;
import com.xjtuse.summerproject.controllerEntity.GetStudentHomeworkDetailResponse;
import com.xjtuse.summerproject.mapper.TeacherMapper;
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
public class GetStudentHomeworkDetail {
    @RequestMapping("/GetStudentHomeworkDetail")
    public @ResponseBody
    GetStudentHomeworkDetailResponse getStudentHomeworkDetail(@RequestBody GetStudentHomeworkDetailInfo getStudentHomeworkDetailInfo) throws IOException {
        GetStudentHomeworkDetailResponse getStudentHomeworkDetailResponse = new GetStudentHomeworkDetailResponse();
        //1.读取配置文件，生成字节输入流
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //4.使用SqlSession创建Mapper接口的代理对象
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);


        //提交事务
//        sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        in.close();
        return getStudentHomeworkDetailResponse;
    }
}