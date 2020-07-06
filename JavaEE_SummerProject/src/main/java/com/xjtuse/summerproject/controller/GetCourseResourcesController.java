package com.xjtuse.summerproject.controller;

import com.xjtuse.summerproject.controllerEntity.CourseResource;
import com.xjtuse.summerproject.controllerEntity.GetCourseXXXsInfo;
import com.xjtuse.summerproject.controllerEntity.GetCourseXXXsResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GetCourseResourcesController {
    @RequestMapping("/GetCourseResources")
    public @ResponseBody GetCourseXXXsResponse getCourseResources(@RequestBody GetCourseXXXsInfo getCourseResourcesInfo) {
        GetCourseXXXsResponse getCourseResourcesResponse = new GetCourseXXXsResponse();
        getCourseResourcesResponse.setId("Source10000001");
        getCourseResourcesResponse.setTotal_num(2);
        String resource_name1 = "resource_name1";
        String resource_path1 = "服务器上resource1的地址";
        Integer resource_size1 = 1024*10;
        String resource_upload_time1 = "upload_time_of_resource1";
        String resource_type1 = "pdf";
        String resource_name2 = "resource_name2";
        String resource_path2 = "服务器上resource2的地址";
        Integer resource_size2 = 1024*15;
        String resource_upload_time2 = "upload_time_of_resource2";
        String resource_type2 = "mp4";
        List<Object> list = new ArrayList();
        CourseResource courseResource1 = new CourseResource();
        CourseResource courseResource2 = new CourseResource();
        courseResource1.setResource_name(resource_name1);
        courseResource1.setResource_path(resource_path1);
        courseResource1.setResource_size(resource_size1);
        courseResource1.setResource_upload_time(resource_upload_time1);
        courseResource1.setResource_type(resource_type2);
        courseResource2.setResource_name(resource_name2);
        courseResource2.setResource_path(resource_path2);
        courseResource2.setResource_size(resource_size2);
        courseResource2.setResource_upload_time(resource_upload_time2);
        courseResource2.setResource_type(resource_type2);
        list.add(courseResource1);
        list.add(courseResource2);
        getCourseResourcesResponse.setValue(list);
        return getCourseResourcesResponse;
    }
}
