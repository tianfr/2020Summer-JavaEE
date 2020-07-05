package com.xjtuse.summerproject;

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
    public void testInsertStudent() throws Exception{
        Student student = new Student();
        student.setStuId("2176112631");
        student.setStuName("曹大华");
        student.setStuAge("21");
        student.setStuGender("男");
        student.setStuClass("软件73");
        student.setStuEmail("940141567@qq.com");
        student.setStuUsername("cdh");
        student.setStuPassword("123");
        Date now = new Date(System.currentTimeMillis());
        student.setInsertDate(now);
        //5.执行insertStudent方法
        studentMapper.insertStudent(student);
    }

    @Test
    public void testUpdateStudent() throws Exception{
        Student student = new Student();
        student.setStuId("2176112631");
        student.setStuName("曹大华");
        student.setStuAge("20");
        student.setStuGender("男");
        student.setStuClass("信计71");
        student.setStuEmail("940141567@qq.com");
        student.setStuUsername("cdh");
        student.setStuPassword("123");
        Date now = new Date(System.currentTimeMillis());
        student.setInsertDate(now);
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
        Student student = studentMapper.findById("2171311001");
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