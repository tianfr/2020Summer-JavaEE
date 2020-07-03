package com.xjtuse.summerproject.entity;

import java.io.Serializable;

public class GetCoursePanelInfo implements Serializable {
    private String status;
    private String message;
    private String course;
    private String teacher_user_name;

    @Override
    public String toString() {
        return "GetCoursePanelInfo{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", course='" + course + '\'' +
                ", teacher_user_name='" + teacher_user_name + '\'' +
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

    public String getTeacher_user_name() {
        return teacher_user_name;
    }

    public void setTeacher_user_name(String teacher_user_name) {
        this.teacher_user_name = teacher_user_name;
    }
}
