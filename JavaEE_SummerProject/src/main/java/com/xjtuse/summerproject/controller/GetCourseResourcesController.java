package com.xjtuse.summerproject.controller;

import com.xjtuse.summerproject.controllerEntity.CourseResource;
import com.xjtuse.summerproject.controllerEntity.GetCourseXXXsInfo;
import com.xjtuse.summerproject.controllerEntity.GetCourseXXXsResponse;
import com.xjtuse.summerproject.entity.CourseContent;
import com.xjtuse.summerproject.mapper.StudentMapper;
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
public class GetCourseResourcesController {
    @RequestMapping("/GetCourseResources")
    public @ResponseBody GetCourseXXXsResponse getCourseResources(@RequestBody GetCourseXXXsInfo getCourseResourcesInfo) throws IOException {
        //1.读取配置文件，生成字节输入流
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //4.使用SqlSession创建Mapper接口的代理对象
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<com.xjtuse.summerproject.entity.CourseResource> courseResourceList = studentMapper.getCourseResource(getCourseResourcesInfo.getCourse_id());
        //提交事务
//        sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        in.close();
        List<Object> list = new ArrayList();
        GetCourseXXXsResponse getCourseResourcesResponse = new GetCourseXXXsResponse();
        getCourseResourcesResponse.setTotal_num(0);
        String id = "course_resources";
        for (com.xjtuse.summerproject.entity.CourseResource courseResource: courseResourceList){
            CourseResource entityCourseResource = new CourseResource();
            entityCourseResource.setResource_name(courseResource.getResource_name());
            entityCourseResource.setResource_path(courseResource.getResource_path());
            entityCourseResource.setResource_size(null);
            entityCourseResource.setResource_type(courseResource.getResource_type());
            entityCourseResource.setResource_upload_time(courseResource.getInsert_date().toString());
            list.add(entityCourseResource);
            getCourseResourcesResponse.setTotal_num(getCourseResourcesResponse.getTotal_num() + 1);
        }


        getCourseResourcesResponse.setId(id);
        getCourseResourcesResponse.setValue(list);
        return getCourseResourcesResponse;












//        String resource_name1 = "resource_name1";
//        String resource_path1 = "服务器上resource1的地址";
//        Integer resource_size1 = 1024*10;
//        String resource_upload_time1 = "upload_time_of_resource1";
//        String resource_type1 = "pdf";
//        String resource_name2 = "resource_name2";
//        String resource_path2 = "服务器上resource2的地址";
//        Integer resource_size2 = 1024*15;
//        String resource_upload_time2 = "upload_time_of_resource2";
//        String resource_type2 = "mp4";
//        List<Object> list = new ArrayList();
//        CourseResource courseResource1 = new CourseResource();
//        CourseResource courseResource2 = new CourseResource();
//        courseResource1.setResource_name(resource_name1);
//        courseResource1.setResource_path(resource_path1);
//        courseResource1.setResource_size(resource_size1);
//        courseResource1.setResource_upload_time(resource_upload_time1);
//        courseResource1.setResource_type(resource_type2);
//        courseResource2.setResource_name(resource_name2);
//        courseResource2.setResource_path(resource_path2);
//        courseResource2.setResource_size(resource_size2);
//        courseResource2.setResource_upload_time(resource_upload_time2);
//        courseResource2.setResource_type(resource_type2);
//        list.add(courseResource1);
//        list.add(courseResource2);
//        getCourseResourcesResponse.setValue(list);

    }
}
