package com.xjtuse.summerproject.entity;

public class SubmitHomework {
    // This java class is used for inserting student new homework, which needs a class for pushing paras.
    private String course_id;
    private String homework_id;
    private String student_id;
    private String is_draft;
    private String homework_content;
    private String homework_attachments_path;
    private String homework_attachments_name;

    @Override
    public String toString() {
        return "SubmitHomework{" +
                "course_id='" + course_id + '\'' +
                ", homework_id='" + homework_id + '\'' +
                ", student_id='" + student_id + '\'' +
                ", is_draft='" + is_draft + '\'' +
                ", homework_content='" + homework_content + '\'' +
                ", homework_attachments_path='" + homework_attachments_path + '\'' +
                ", homework_attachments_name='" + homework_attachments_name + '\'' +
                '}';
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

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
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

    public String getHomework_attachments_path() {
        return homework_attachments_path;
    }

    public void setHomework_attachments_path(String homework_attachments_path) {
        this.homework_attachments_path = homework_attachments_path;
    }

    public String getHomework_attachments_name() {
        return homework_attachments_name;
    }

    public void setHomework_attachments_name(String homework_attachments_name) {
        this.homework_attachments_name = homework_attachments_name;
    }
}
