package com.xjtuse.summerproject.entity;

import java.io.Serializable;
import java.util.List;

public class GetExistedHomeworkResponse implements Serializable {
    private String homework_status;
    private String homework_content;
    private String submitted_time;
    private String homework_deadline;
    private String have_attachments;
    private List<File> homework_attachments;

    @Override
    public String toString() {
        return "GetExistedHomeworkResponse{" +
                "homework_status='" + homework_status + '\'' +
                ", homework_content='" + homework_content + '\'' +
                ", submitted_time='" + submitted_time + '\'' +
                ", homework_deadline='" + homework_deadline + '\'' +
                ", have_attachments='" + have_attachments + '\'' +
                ", homework_attachments=" + homework_attachments +
                '}';
    }

    public String getHomework_status() {
        return homework_status;
    }

    public void setHomework_status(String homework_status) {
        this.homework_status = homework_status;
    }

    public String getHomework_content() {
        return homework_content;
    }

    public void setHomework_content(String homework_content) {
        this.homework_content = homework_content;
    }

    public String getSubmitted_time() {
        return submitted_time;
    }

    public void setSubmitted_time(String submitted_time) {
        this.submitted_time = submitted_time;
    }

    public String getHomework_deadline() {
        return homework_deadline;
    }

    public void setHomework_deadline(String homework_deadline) {
        this.homework_deadline = homework_deadline;
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
