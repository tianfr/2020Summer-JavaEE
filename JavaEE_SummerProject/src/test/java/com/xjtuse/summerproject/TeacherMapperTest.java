package com.xjtuse.summerproject;

import com.xjtuse.summerproject.controllerEntity.GetStudentHomeworkDetailInfo;
import com.xjtuse.summerproject.entity.*;
import com.xjtuse.summerproject.mapper.StudentMapper;
import com.xjtuse.summerproject.mapper.TeacherMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Date;
import java.util.List;


public class TeacherMapperTest {

    private InputStream in;
    private SqlSession sqlSession;
    private TeacherMapper teacherMapper;

    @Before
    public void init() throws Exception{

        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产SqlSession对象
        sqlSession = factory.openSession();
        //4.使用SqlSession创建Mapper接口的代理对象
        teacherMapper = sqlSession.getMapper(TeacherMapper.class);
    }

    @After
    public void destroy() throws Exception {
        //提交事务
        sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindById() throws Exception{
        Teacher teacher = teacherMapper.findByUsername("caodahua");
        System.out.println("teacher = " + teacher);
    }


    @Test
    public void testUpdateTeacherPasswordByUsername() throws Exception{
        Teacher teacher = new Teacher();
        teacher.setTeacher_username("caodahua");
        teacher.setTeacher_password("123456");
        teacherMapper.updateTeacherPasswordByUsername(teacher);
    }

    @Test
    public void testGetStudentHomework() throws Exception{
        SendHomework sendHomework = new SendHomework();
        sendHomework.setHomework_id("tch20200101_content_homework101");
        sendHomework.setCourse_id("demo001");
        List<CourseHomework> courseHomeworkList = teacherMapper.getStudentHomeworks(sendHomework);
        for (CourseHomework courseHomework: courseHomeworkList){
            System.out.println(courseHomework);
        }
    }

    @Test
    public void testGetPrevCourses() throws Exception{
        List<Course> courseList = teacherMapper.getprevCourses("tch20200101");
        for (Course course: courseList){
            System.out.println(course);
        }
    }

    @Test
    public void testGetSubmittedhomework() throws Exception{
        SendHomework sendHomework = new SendHomework();
        sendHomework.setCourse_id("demo001");
        sendHomework.setHomework_id("tch20200101_content_homework101");
        List<CourseHomework> courseHomeworkList = teacherMapper.getSubmittedHomework(sendHomework);
        for (CourseHomework courseHomework: courseHomeworkList){
            System.out.println(courseHomework);
        }
    }


    @Test
    public void testGethomework() throws Exception{
        GetStudentHomeworkDetailInfo getStudentHomeworkDetailInfo = new GetStudentHomeworkDetailInfo();
        getStudentHomeworkDetailInfo.setCourse_id("demo001");
        getStudentHomeworkDetailInfo.setStudent_id("stu20200306");
        getStudentHomeworkDetailInfo.setHomework_id("tch20200101_content_homework101");
        CourseHomework courseHomework = teacherMapper.getHomeworkDetail(getStudentHomeworkDetailInfo);
        System.out.println("courseHomework = " + courseHomework);
    }
}
