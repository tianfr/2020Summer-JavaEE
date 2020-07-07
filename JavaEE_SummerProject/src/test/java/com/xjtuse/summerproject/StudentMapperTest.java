package com.xjtuse.summerproject;

import com.xjtuse.summerproject.entity.Course;
import com.xjtuse.summerproject.entity.Student;
import com.xjtuse.summerproject.mapper.StudentMapper;
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


public class StudentMapperTest {

    private InputStream in;
    private SqlSession sqlSession;
    private StudentMapper studentMapper;

    @Before
    public void init() throws Exception{

        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产SqlSession对象
        sqlSession = factory.openSession();
        //4.使用SqlSession创建Mapper接口的代理对象
        studentMapper = sqlSession.getMapper(StudentMapper.class);
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
    public void testFindAll() {
        //5.执行findAll方法
        List<Student> students = studentMapper.findAll();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void testFindAllCourseById() {
        //5.执行findAll方法
        List<Course> courses = studentMapper.findAllCourseById("stu20200202");
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    @Test
    public void testFindMaxId() {
        //5.执行findMaxId方法
        String maxid = studentMapper.findMaxId();
        System.out.println("maxid = " + maxid);
    }

    @Test
    public void testInsertStudent() throws Exception{
        Student student = new Student();
        student.setStudent_id("2176112631");
        student.setStudent_name("曹大华");
        student.setStudent_age("21");
        student.setStudent_gender("男");
        student.setStudent_class("软件73");
        student.setStudent_email("940141567@qq.com");
        student.setStudent_username("cdh");
        student.setStudent_password("123");
        Date now = new Date(System.currentTimeMillis());
        student.setInsert_date(now);
        //5.执行insertStudent方法
        studentMapper.insertStudent(student);
    }

    @Test
    public void testUpdateStudent() throws Exception{
        Student student = new Student();
        student.setStudent_id("2176112631");
        student.setStudent_name("曹大华");
        student.setStudent_age("20");
        student.setStudent_gender("男");
        student.setStudent_class("信计71");
        student.setStudent_email("940141567@qq.com");
        student.setStudent_username("cdh");
        student.setStudent_password("123");
        Date now = new Date(System.currentTimeMillis());
        student.setInsert_date(now);
        //5.执行updateStudent方法
        studentMapper.updateStudent(student);
    }

    @Test
    public void testDeleteStudent() throws Exception{
        //5.执行deleteStudent方法
        studentMapper.deleteStudent("2176112631");
    }

    @Test
    public void testFindById() throws Exception{
        //5.执行findById方法
        Student student = studentMapper.findById("stu20200101");
        System.out.println("student = " + student);
    }

    @Test
    public void testFindByName() throws Exception{
        //5.执行findByName方法
        List<Student> students = studentMapper.findByName("%杨%");
        //List<Student> students = studentMapper.findByName("杨");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void testFindTotal() throws Exception{
        //5.执行findByName方法
        Integer count = studentMapper.findTotal();
        System.out.println("count = " + count);
    }
}
