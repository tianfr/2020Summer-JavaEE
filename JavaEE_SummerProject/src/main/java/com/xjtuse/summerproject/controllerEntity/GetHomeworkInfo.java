package com.xjtuse.summerproject.controllerEntity;

import java.io.Serializable;

public class GetHomeworkInfo implements Serializable {
    private String status;
    private String message;
    private String course_id;
    private String homework_id;

    @Override
    public String toString() {
        return "GetHomeworkInfo{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", course_id='" + course_id + '\'' +
                ", homework_id='" + homework_id + '\'' +
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

    public String getHomework_id() {
        return homework_id;
    }

    public void setHomework_id(String homework_id) {
        this.homework_id = homework_id;
    }
}
