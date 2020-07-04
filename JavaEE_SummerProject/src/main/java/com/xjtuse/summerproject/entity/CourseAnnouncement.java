package com.xjtuse.summerproject.entity;

import java.io.Serializable;

public class CourseAnnouncement implements Serializable {
    private String announcement_title;
    private String announcement_id;
    private String announcement_content;

    @Override
    public String toString() {
        return "CourseAnnouncement{" +
                "announcement_title='" + announcement_title + '\'' +
                ", announcement_id='" + announcement_id + '\'' +
                ", announcement_content='" + announcement_content + '\'' +
                '}';
    }

    public String getAnnouncement_title() {
        return announcement_title;
    }

    public void setAnnouncement_title(String announcement_title) {
        this.announcement_title = announcement_title;
    }

    public String getAnnouncement_id() {
        return announcement_id;
    }

    public void setAnnouncement_id(String announcement_id) {
        this.announcement_id = announcement_id;
    }

    public String getAnnouncement_content() {
        return announcement_content;
    }

    public void setAnnouncement_content(String announcement_content) {
        this.announcement_content = announcement_content;
    }
}
