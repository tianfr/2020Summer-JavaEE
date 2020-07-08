package com.xjtuse.summerproject.controllerEntity;

import java.io.Serializable;

public class GetAnnouncementInfo implements Serializable {
    private String status;
    private String message;
    private String course_id;
    private String announcement_id;

    @Override
    public String toString() {
        return "GetAnnouncementInfo{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", course_id='" + course_id + '\'' +
                ", announcement_id='" + announcement_id + '\'' +
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

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getAnnouncement_id() {
        return announcement_id;
    }

    public void setAnnouncement_id(String announcement_id) {
        this.announcement_id = announcement_id;
    }
}
