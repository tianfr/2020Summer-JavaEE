package com.xjtuse.summerproject.controller;

import com.xjtuse.summerproject.controllerEntity.LoginInfo;
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

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class LoginController {
    @RequestMapping("/Login")
    public @ResponseBody
    ResponseInfo login(@RequestBody LoginInfo loginInfo, HttpSession session) throws IOException {
        ResponseInfo responseInfo = new ResponseInfo();
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = studentMapper.findByUsername(loginInfo.getUser_name());
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = teacherMapper.findByUsername(loginInfo.getUser_name());
        //  sqlSession.commit();
        sqlSession.close();
        in.close();
        if(student == null && teacher == null) {//如果用户名不存在
            responseInfo.setSuccess_value("0");
            responseInfo.setFail_content("用户名不存在");
        }
        else if (student != null) {
            if (student.getStudent_password().equals(loginInfo.getPass_word())){ //密码正确
                responseInfo.setSuccess_value("1");
                responseInfo.setRole("student");
                responseInfo.setRole_id(student.getStudent_id());
                responseInfo.setFail_content("密码正确");
                session.setAttribute("role", "student");
                session.setAttribute("username", student.getStudent_username());
                session.setAttribute("id", student.getStudent_id());
                session.setAttribute("email", student.getStudent_email());
                session.setAttribute("name", student.getStudent_name());
            }
            else {
                responseInfo.setSuccess_value("0");
                responseInfo.setFail_content("密码错误");
            }
        }
        else if (teacher != null) {
            if (teacher.getTeacher_password().equals(loginInfo.getPass_word())){
                responseInfo.setSuccess_value("1");
                responseInfo.setRole("student");
                responseInfo.setRole_id(teacher.getTeacher_id());
                responseInfo.setFail_content("密码正确");
                session.setAttribute("role", "teacher");
                session.setAttribute("username", teacher.getTeacher_username());
                session.setAttribute("id", teacher.getTeacher_id());
                session.setAttribute("email", teacher.getTeacher_email());
                session.setAttribute("name", teacher.getTeacher_name());
            }
            else {
                responseInfo.setSuccess_value("0");
                responseInfo.setFail_content("密码错误");
            }
        }
        return responseInfo;
    }
}
