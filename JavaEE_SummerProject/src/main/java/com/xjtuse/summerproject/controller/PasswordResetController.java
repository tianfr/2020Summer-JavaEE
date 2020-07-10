package com.xjtuse.summerproject.controller;

import com.xjtuse.summerproject.controllerEntity.PasswordResetInfo;
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

import java.io.InputStream;
import java.util.Date;

@Controller
public class PasswordResetController {

    @RequestMapping("/PasswordReset")
    public @ResponseBody
    ResponseInfo passwordReset(@RequestBody PasswordResetInfo passwordResetInfo) throws Exception {
        System.out.println("passwordResetInfo = " + passwordResetInfo);
        ResponseInfo responseInfo = new ResponseInfo();
        String seed = "myNAMEisCDH"; // des加密时使用的key

        //----------在用户登录邮箱访问重置密码链接后对链接的参数进行解密------
        String p = com.xjtuse.summerproject.encrytion.DESUtil.decrypt(seed, passwordResetInfo.getKey());
        System.out.println("-----------解密后的key参数---------------------");
        System.out.println(p);
        String time = p.split("@")[0];
        String username = p.split("@")[1];
        long timenow = new Date().getTime();
        if(timenow - Long.valueOf(time) < 0 || timenow - Long.valueOf(time) > 1800000) {
            responseInfo.setSuccess_value("0");
            responseInfo.setFail_content("该链接已失效");
            return responseInfo;
        }
        System.out.println("username = " + username);
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher tch = new Teacher();
        Student stu = new Student();
        tch.setTeacher_username(username);
        tch.setTeacher_password(passwordResetInfo.getPassword());
        stu.setStudent_username(username);
        stu.setStudent_password(passwordResetInfo.getPassword());
        studentMapper.updateStudentPasswordByUsername(stu);
        teacherMapper.updateTeacherPasswordByUsername(tch);
        sqlSession.commit();
        sqlSession.close();
        in.close();
        responseInfo.setSuccess_value("1");
        responseInfo.setFail_content("成功");
        return responseInfo;
    }
}
