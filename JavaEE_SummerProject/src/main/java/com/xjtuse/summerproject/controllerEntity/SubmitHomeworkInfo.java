package com.xjtuse.summerproject.controllerEntity;

import java.io.Serializable;
import java.util.List;

public class SubmitHomeworkInfo implements Serializable {
    private String status;
    private String message;
    private String course_id;
    private String homework_id;
    private String is_draft;
    private String homework_content;
    private String have_attachments;
    private List<File> homework_attachments;

    @Override
    public String toString() {
        return "SubmitHomeworkInfo{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", course_id='" + course_id + '\'' +
                ", homework_id='" + homework_id + '\'' +
                ", is_draft='" + is_draft + '\'' +
                ", homework_content='" + homework_content + '\'' +
                ", have_attachments='" + have_attachments + '\'' +
                ", homework_attachments=" + homework_attachments +
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

    public String getIs_draft() {
        return is_draft;
    }

    public void setIs_draft(String is_draft) {
        this.is_draft = is_draft;
    }

    public String getHomework_content() {
        return homework_content;
    }

    public void setHomework_content(String homework_content) {
        this.homework_content = homework_content;
    }

    public String getHave_attachments() {
        return have_attachments;
    }

    public void setHave_attachments(String have_attachments) {
        this.have_attachments = have_attachments;
    }

    public List<File> getHomework_attachments() {
        return homework_attachments;
    }

    public void setHomework_attachments(List<File> homework_attachments) {
        this.homework_attachments = homework_attachments;
    }
}
