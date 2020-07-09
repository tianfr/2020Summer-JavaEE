package com.xjtuse.summerproject.controllerEntity;

import org.springframework.stereotype.Controller;

import java.io.Serializable;
import java.util.List;

public class SubmitHomeworkInfo implements Serializable {
    private String status;
    private String message;
    private String course_id;
    private String homework_id;
    private String homework_content;

    @Override
    public String toString() {
        return "SubmitHomeworkInfo{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", course_id='" + course_id + '\'' +
                ", homework_id='" + homework_id + '\'' +
                ", homework_content='" + homework_content + '\'' +
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

    public String getHomework_content() {
        return homework_content;
    }

    public void setHomework_content(String homework_content) {
        this.homework_content = homework_content;
    }
}
