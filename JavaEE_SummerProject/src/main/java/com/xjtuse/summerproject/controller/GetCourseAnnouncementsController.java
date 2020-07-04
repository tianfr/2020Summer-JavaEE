package com.xjtuse.summerproject.controller;

import com.xjtuse.summerproject.entity.CourseAnnouncement;
import com.xjtuse.summerproject.entity.GetCourseXXXsInfo;
import com.xjtuse.summerproject.entity.GetCourseXXXsResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GetCourseAnnouncementsController {

    @RequestMapping("/GetCourseAnnouncements")
    public @ResponseBody
    GetCourseXXXsResponse getCourseAnnouncements(@RequestBody GetCourseXXXsInfo getCourseAnnouncementsInfo) {
        GetCourseXXXsResponse getCourseAnnouncementsResponse = new GetCourseXXXsResponse();
        getCourseAnnouncementsResponse.setId("course_announcement");
        Integer num_of_total_announcements = 2;
        getCourseAnnouncementsResponse.setTotal_num(num_of_total_announcements);
        String announcement_title1 = "announcement_title1";
        String announcement_title2 = "announcement_title2";
        String announcement_id1 = "announcement_id1";
        String announcement_id2 = "announcement_id2";
        String announcement_content1 = "announcement_content1";
        String announcement_content2 = "announcement_content2";
        List<Object> list = new ArrayList();
        CourseAnnouncement courseAnnouncement1 = new CourseAnnouncement();
        CourseAnnouncement courseAnnouncement2 = new CourseAnnouncement();
        courseAnnouncement1.setAnnouncement_title(announcement_title1);
        courseAnnouncement1.setAnnouncement_id(announcement_id1);
        courseAnnouncement1.setAnnouncement_content(announcement_content1);
        courseAnnouncement2.setAnnouncement_title(announcement_title2);
        courseAnnouncement2.setAnnouncement_id(announcement_id2);
        courseAnnouncement2.setAnnouncement_content(announcement_content2);
        list.add(courseAnnouncement1);
        list.add(courseAnnouncement2);
        getCourseAnnouncementsResponse.setValue(list);
        System.out.println("getCourseAnnouncementsResponse = " + getCourseAnnouncementsResponse);
        return getCourseAnnouncementsResponse;
    }
}
