package com.xjtuse.summerproject.controllerEntity;

import java.io.Serializable;
import java.util.List;

public class GetStudentHomeworkDetailResponse implements Serializable {
    private String student_name;
    private String student_email;
    private String student_avatar;
    private String submitted_time;
    private String homework_content;
    private List<File> homework_attachments;

    @Override
    public String toString() {
        return "GetStudentHomeworkDetailResponse{" +
                "student_name='" + student_name + '\'' +
                ", student_email='" + student_email + '\'' +
                ", student_avatar='" + student_avatar + '\'' +
                ", submitted_time='" + submitted_time + '\'' +
                ", homework_content='" + homework_content + '\'' +
                ", homework_attachments=" + homework_attachments +
                '}';
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_email() {
        return student_email;
    }

    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }

    public String getStudent_avatar() {
        return student_avatar;
    }

    public void setStudent_avatar(String student_avatar) {
        this.student_avatar = student_avatar;
    }

    public String getSubmitted_time() {
        return submitted_time;
    }

    public void setSubmitted_time(String submitted_time) {
        this.submitted_time = submitted_time;
    }

    public String getHomework_content() {
        return homework_content;
    }

    public void setHomework_content(String homework_content) {
        this.homework_content = homework_content;
    }

    public List<File> getHomework_attachments() {
        return homework_attachments;
    }

    public void setHomework_attachments(List<File> homework_attachments) {
        this.homework_attachments = homework_attachments;
    }
}
