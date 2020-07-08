package com.xjtuse.summerproject.controller;

import com.xjtuse.summerproject.controllerEntity.GetPrevCoursesInfo;
import com.xjtuse.summerproject.controllerEntity.GetPrevCoursesResponse;
import com.xjtuse.summerproject.controllerEntity.GetPrevCoursesSubResponse;
import com.xjtuse.summerproject.entity.Course;
import com.xjtuse.summerproject.entity.CourseResource;
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
import java.util.ArrayList;
import java.util.List;

@Controller
public class GetPrevCoursesController {
    // 6.17 接口
    @RequestMapping("/GetPrevCourses")
    public @ResponseBody
    GetPrevCoursesResponse getPrevCourses(@RequestBody GetPrevCoursesInfo getPrevCoursesInfo) throws IOException {
        GetPrevCoursesResponse getPrevCoursesResponse = new GetPrevCoursesResponse();
        //1.读取配置文件，生成字节输入流
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //4.使用SqlSession创建Mapper接口的代理对象
        String person_role = getPrevCoursesInfo.getRole();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Course> courseList = null;
        if (person_role == "student"){
            courseList = studentMapper.getStudentAttendedCourses(getPrevCoursesInfo.getPerson_id());
        }
        else if (person_role == "teacher"){
            courseList = teacherMapper.getprevCourses(getPrevCoursesInfo.getPerson_id());
        }
        sqlSession.close();
        in.close();
        getPrevCoursesResponse.setId("prev_courses");
        getPrevCoursesResponse.setTotal_num(0);
        List<GetPrevCoursesSubResponse> list = new ArrayList();
        for (Course course: courseList){
            GetPrevCoursesSubResponse entityCourse = new GetPrevCoursesSubResponse();
            entityCourse.setCourse_title(course.getCourse_name());
            entityCourse.setCourse_id(course.getCourse_id());
            entityCourse.setCourse_college(course.getCourse_college());
            entityCourse.setCourse_id(course.getCourse_id());
            getPrevCoursesResponse.setTotal_num(getPrevCoursesResponse.getTotal_num() + 1);
            list.add(entityCourse);
        }
        getPrevCoursesResponse.setValue(list);
//        <CourseResource> courseResourceList = studentMapper.getCourseResource(getCourseResourcesInfo.getCourse_id());
        //提交事务
//        sqlSession.commit();
        //6.释放资源

        return getPrevCoursesResponse;
    }


}
