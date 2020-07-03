package com.xjtuse.summerproject.controller;

import com.xjtuse.summerproject.entity.CourseAnnouncement;
import com.xjtuse.summerproject.entity.GetCourseAnnouncementInfo;
import com.xjtuse.summerproject.entity.GetCourseAnnouncementResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GetCourseAnnouncementController {

    @RequestMapping("/GetCourseAnnouncement")
    public @ResponseBody
    GetCourseAnnouncementResponse getCourseAnnouncement(@RequestBody GetCourseAnnouncementInfo getCourseAnnouncementInfo) {
        GetCourseAnnouncementResponse getCourseAnnouncementResponse = new GetCourseAnnouncementResponse();
        getCourseAnnouncementResponse.setId("course_announcement");
        Integer num_of_total_announcement = 2;
        getCourseAnnouncementResponse.setTotal_num(num_of_total_announcement);
        String announcement_title1 = "announcement_title1";
        String announcement_title2 = "announcement_title2";
        String announcement_path1 = "announcement_path1";
        String announcement_path2 = "announcement_path2";
        String announcement_content1 = "announcement_content1";
        String announcement_content2 = "announcement_content2";
        List<CourseAnnouncement> list = new ArrayList<CourseAnnouncement>();
        CourseAnnouncement courseAnnouncement1 = new CourseAnnouncement();
        CourseAnnouncement courseAnnouncement2 = new CourseAnnouncement();
        courseAnnouncement1.setAnnouncement_title(announcement_title1);
        courseAnnouncement1.setAnnouncement_path(announcement_path1);
        courseAnnouncement1.setAnnouncement_content(announcement_content1);
        courseAnnouncement2.setAnnouncement_title(announcement_title2);
        courseAnnouncement2.setAnnouncement_path(announcement_path2);
        courseAnnouncement2.setAnnouncement_content(announcement_content2);
        list.add(courseAnnouncement1);
        list.add(courseAnnouncement2);
        getCourseAnnouncementResponse.setValue(list);
        return getCourseAnnouncementResponse;
    }
}
