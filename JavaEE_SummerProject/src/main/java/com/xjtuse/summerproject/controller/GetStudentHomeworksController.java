package com.xjtuse.summerproject.controller;

import com.xjtuse.summerproject.controllerEntity.GetHomeworkInfo;
import com.xjtuse.summerproject.controllerEntity.GetStudentHomeworksResponse;
import com.xjtuse.summerproject.controllerEntity.GetStudentHomeworksResponseSub;
import com.xjtuse.summerproject.entity.CourseContent;
import com.xjtuse.summerproject.entity.CourseHomework;
import com.xjtuse.summerproject.entity.SendHomework;
import com.xjtuse.summerproject.mapper.StudentMapper;
import com.xjtuse.summerproject.mapper.TeacherMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class GetStudentHomeworksController {
    // 6.18
    @RequestMapping("/GetStudentHomeworks")
    public @ResponseBody
    GetStudentHomeworksResponse getStudentHomeworks(@RequestBody GetHomeworkInfo getHomeworkInfo) throws IOException {
        GetStudentHomeworksResponse getStudentHomeworksResponse = new GetStudentHomeworksResponse();
        //1.读取配置文件，生成字节输入流
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //4.使用SqlSession创建Mapper接口的代理对象
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);


        getStudentHomeworksResponse.setTotal_num(0);
        SendHomework sendHomework = new SendHomework();
        sendHomework.setCourse_id(getHomeworkInfo.getCourse_id());
        sendHomework.setHomework_id(getHomeworkInfo.getHomework_id());
        List<CourseHomework> courseHomeworkList = teacherMapper.getStudentHomeworks(sendHomework);


        //提交事务
//        sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        in.close();
        List<GetStudentHomeworksResponseSub> getStudentHomeworksResponseSubs = new ArrayList<>();
        for (CourseHomework courseHomework: courseHomeworkList){
            GetStudentHomeworksResponseSub getStudentHomeworksResponseSub = new GetStudentHomeworksResponseSub();
            getStudentHomeworksResponseSub.setStudent_id(courseHomework.getStudent_id());
            getStudentHomeworksResponseSub.setHomework_title(courseHomework.getContent());
            getStudentHomeworksResponseSub.setHomework_content(courseHomework.getContent());
            getStudentHomeworksResponseSub.setHomework_file_name(courseHomework.getHomework_file_name());
            getStudentHomeworksResponseSub.setHomework_file_path(courseHomework.getHomewrok_file_path());
            getStudentHomeworksResponseSub.setInsert_date(courseHomework.getInsert_date().toString());
            getStudentHomeworksResponse.setTotal_num(getStudentHomeworksResponse.getTotal_num() + 1);
            getStudentHomeworksResponseSubs.add(getStudentHomeworksResponseSub);
        }
        getStudentHomeworksResponse.setHomeworks(getStudentHomeworksResponseSubs);
        return getStudentHomeworksResponse;




    }

}
