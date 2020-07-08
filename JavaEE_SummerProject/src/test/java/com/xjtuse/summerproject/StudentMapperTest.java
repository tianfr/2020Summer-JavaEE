package com.xjtuse.summerproject;

import com.xjtuse.summerproject.entity.Course;
import com.xjtuse.summerproject.entity.Student;
import com.xjtuse.summerproject.controllerEntity.CourseAnnouncement;
import com.xjtuse.summerproject.entity.*;
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
import java.text.SimpleDateFormat;
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
        String s = "";
        System.out.println("s.split(\";\").length = " + s.split(";").length);
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
    @Test
    public void testGetCourseAnnouncement() throws Exception{
        //5.执行findByName方法
        List<CourseContent> courseAnnouncements = studentMapper.getCourseAnnouncements("demo001");
        System.out.println(courseAnnouncements);
    }

    @Test
    public void testGetAnnouncement() throws Exception{

        SendAnnouncement sendAnnouncement = new SendAnnouncement();
        sendAnnouncement.setAnnouncement_id("tch20200101_content_announcement001");
        sendAnnouncement.setCourse_id("demo001");
        CourseContent courseContent = studentMapper.getAnnouncement(sendAnnouncement);
        System.out.println(courseContent);
        Teacher teacher = studentMapper.getAnnouncementTeacher("tch20200101");
        System.out.println(teacher);
    }
    @Test
    public void testGetCourseHomework() throws Exception{
        List<CourseContent> courseHomeworks = studentMapper.getCourseHomeworks("demo001");
        System.out.println(courseHomeworks);
    }

    @Test
    public void testGetHomework() throws Exception{
        SendHomework sendHomework = new SendHomework();
        sendHomework.setCourse_id("demo001");
        sendHomework.setHomework_id("tch20200101_content_homework001");
        CourseContent courseHomework = studentMapper.getHomework(sendHomework);
        System.out.println(courseHomework);
        Teacher teacher = studentMapper.getAnnouncementTeacher("tch20200101");
        System.out.println(teacher);

    }

    @Test
    public void testInsertHomework() throws Exception{
        SubmitHomework submitHomework = new SubmitHomework();
        submitHomework.setCourse_id("demo001");
        submitHomework.setHomework_id("tch20200101_content_homework001");
        submitHomework.setStudent_id("stu20200204");
        submitHomework.setHomework_attachments_name("name1;name2;");
        submitHomework.setHomework_attachments_path("path1;path2;");
        submitHomework.setHomework_content("newnewneweenewenwenwewndsjflskdfjslkdfjaslk");
        submitHomework.setIs_draft("no");
        studentMapper.insertStudentHomework(submitHomework);


    }

    @Test
    public void testGetHomeworkDraft() throws Exception{
        SendHomework sendHomework = new SendHomework();
        sendHomework.setHomework_id("tch20200101_content_homework001");
        sendHomework.setCourse_id("demo001");
        sendHomework.setStudent_id("stu20200203");
        CourseHomework courseHomework = studentMapper.getHomeworkDraft(sendHomework);
        System.out.println();
    }

    @Test
    public void testGetCourseResourse() throws Exception{
        List<CourseResource> courseResourceList = studentMapper.getCourseResource("demo001");
        System.out.println(courseResourceList);
    }
    @Test
    public void testInsertIssue() throws Exception{
        MaxIssueId maxIssueId = new MaxIssueId();
        maxIssueId.setCourse_id("demo001");
        maxIssueId.setIssue_type("examination");

        String id_number = studentMapper.getMaxIssueId(maxIssueId);
        System.out.println(id_number);
        CourseContent courseContent = new CourseContent();
        courseContent.updateIssueId(id_number);
        courseContent.setIssue_attachment_path("file_id1;file_id2;");
        courseContent.setIssue_attachment_name("name_1;name_2;");
        courseContent.setIssue_type("examination");
        courseContent.setIssue_belong("examination");
        courseContent.setIssue_content("suibianxiesuibianxiesuibianxiesuibianxiesuibianxiesuibianxie");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date(simpleDateFormat.parse("2020/11/5 23:59:59").getTime());
        courseContent.setIssue_deadline(date);
        courseContent.setIssue_title("titletitletitle");
        courseContent.setIssue_table("demo001_examination");
        courseContent.setCourse_id("demo001");

        studentMapper.insertCourseContent(courseContent);
    }

    @Test
    public void testGetPersonAttendedCourses() throws Exception{
        List<Course> courseList = studentMapper.getStudentAttendedCourses("stu20200202");
        for (Course course: courseList){
            System.out.println(course);
        }
    }











}
