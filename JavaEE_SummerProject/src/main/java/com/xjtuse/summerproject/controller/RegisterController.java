package com.xjtuse.summerproject.controller;

import com.xjtuse.summerproject.controllerEntity.RegisterInfo;
import com.xjtuse.summerproject.controllerEntity.ResponseInfo;
import com.xjtuse.summerproject.entity.Student;
import com.xjtuse.summerproject.entity.Teacher;
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

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;

@Controller
public class RegisterController {
    @RequestMapping("/Register")
    public @ResponseBody ResponseInfo register(@RequestBody RegisterInfo registerInfo) throws IOException {
        ResponseInfo responseInfo = new ResponseInfo();
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        Student student = studentMapper.findByUsername(registerInfo.getUser_name());
        Teacher teacher = teacherMapper.findByUsername(registerInfo.getUser_name());
        if(student == null && teacher == null) {
            if(registerInfo.getRole().equals("student")) {
                Student newstu = new Student();
                String id = "stu" + String.valueOf((Integer.valueOf(studentMapper.findMaxId().substring(3))+1));
                newstu.setStudent_id(id);
                newstu.setStudent_username(registerInfo.getUser_name());
                newstu.setStudent_password(registerInfo.getPass_word());
                newstu.setStudent_email(registerInfo.getEmail());
                newstu.setStudent_name(registerInfo.getFull_name());
                newstu.setInsert_date(new Date(System.currentTimeMillis()));
                studentMapper.insertStudent(newstu);
                responseInfo.setSuccess_value("1");
                responseInfo.setFail_content("注册成功");
                responseInfo.setRole("student");
                responseInfo.setRole_id(id);
            }
            else {
                Teacher newtc = new Teacher();
                String id = "tch" + String.valueOf((Integer.valueOf(teacherMapper.findMaxId().substring(3))+1));
                newtc.setTeacher_id(id);
                newtc.setTeacher_username(registerInfo.getUser_name());
                newtc.setTeacher_password(registerInfo.getPass_word());
                newtc.setTeacher_email(registerInfo.getEmail());
                newtc.setTeacher_name(registerInfo.getFull_name());
                newtc.setInsert_date(new Date(System.currentTimeMillis()));
                teacherMapper.insertTeacher(newtc);
                responseInfo.setSuccess_value("1");
                responseInfo.setFail_content("注册成功");
                responseInfo.setRole("teacher");
                responseInfo.setRole_id(id);
            }
        }
        else {
            responseInfo.setSuccess_value("0");
            responseInfo.setFail_content("用户名已存在");
        }
        sqlSession.commit();
        sqlSession.close();
        in.close();
        return responseInfo;
    }
}
