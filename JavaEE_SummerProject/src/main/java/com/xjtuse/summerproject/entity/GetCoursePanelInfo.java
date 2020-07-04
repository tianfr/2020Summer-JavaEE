package com.xjtuse.summerproject.entity;

import java.io.Serializable;

public class GetCoursePanelInfo implements Serializable {
    private String status;
    private String message;
    private String course_id;

    @Override
    public String toString() {
        return "GetCoursePanelInfo{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", course_id='" + course_id + '\'' +
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
}
