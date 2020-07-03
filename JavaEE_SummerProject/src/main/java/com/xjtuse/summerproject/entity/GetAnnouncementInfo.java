package com.xjtuse.summerproject.entity;

import java.io.Serializable;

public class GetAnnouncementInfo implements Serializable {
    private String status;
    private String message;
    private String course;
    private String announcement_path;

    @Override
    public String toString() {
        return "GetAnnouncementInfo{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", course='" + course + '\'' +
                ", announcement_path='" + announcement_path + '\'' +
                '}';
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getAnnouncement_path() {
        return announcement_path;
    }

    public void setAnnouncement_path(String announcement_path) {
        this.announcement_path = announcement_path;
    }
}
