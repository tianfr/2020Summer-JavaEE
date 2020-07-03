package com.xjtuse.summerproject.entity;

import java.io.Serializable;

public class CourseAnnouncement implements Serializable {
    private String announcement_title;
    private String announcement_path;
    private String announcement_content;

    @Override
    public String toString() {
        return "CourseAnnouncement{" +
                "announcement_title='" + announcement_title + '\'' +
                ", announcement_path='" + announcement_path + '\'' +
                ", announcement_content='" + announcement_content + '\'' +
                '}';
    }

    public String getAnnouncement_title() {
        return announcement_title;
    }

    public void setAnnouncement_title(String announcement_title) {
        this.announcement_title = announcement_title;
    }

    public String getAnnouncement_path() {
        return announcement_path;
    }

    public void setAnnouncement_path(String announcement_path) {
        this.announcement_path = announcement_path;
    }

    public String getAnnouncement_content() {
        return announcement_content;
    }

    public void setAnnouncement_content(String announcement_content) {
        this.announcement_content = announcement_content;
    }
}
