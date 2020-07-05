package com.xjtuse.summerproject.controller;

import com.xjtuse.summerproject.entity.Announcement;
import com.xjtuse.summerproject.entity.GetAnnouncementInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GetAnnouncementController {

    @RequestMapping("GetAnnouncement")
    public @ResponseBody
    Announcement getAnnouncement(@RequestBody GetAnnouncementInfo getAnnouncementInfo) {
        Announcement announcement = new Announcement();
        String announcement_title = "announcement_title";
        String teacher_name = "杜小智";
        String teacher_email = "xiaozhi_du@xjtu.edu.cn";
        String author_avatar = "img/dxz.jpg";
        String announcement_details = "announcement_details";
        String datetime = "2020-7-3";
        announcement.setAnnouncement_title(announcement_title);
        announcement.setAuthor(teacher_name);
        announcement.setAuthor_email(teacher_email);
        announcement.setAuthor_avatar(author_avatar);
        announcement.setAnnouncement_content(announcement_details);
        announcement.setDatetime(datetime);
        System.out.println("announcement = " + announcement);
        return announcement;
    }
}
