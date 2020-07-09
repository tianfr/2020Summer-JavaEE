package com.xjtuse.summerproject.entity;

import java.security.SecureRandom;
import java.sql.Date;

public class CourseHomework {

    private String homework_id;
    private String student_id;
    private String content;
    private String homework_file_path;
    private String homework_file_name;
    private String is_draft;
    private Date insert_date;

    @Override
    public String toString() {
        return "CourseHomework{" +
                "homework_id='" + homework_id + '\'' +
                ", student_id='" + student_id + '\'' +
                ", content='" + content + '\'' +
                ", homework_file_path='" + homework_file_path + '\'' +
                ", homework_file_name='" + homework_file_name + '\'' +
                ", is_draft='" + is_draft + '\'' +
                ", insert_date=" + insert_date +
                '}';
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHomework_file_path() {
        return homework_file_path;
    }

    public void setHomework_file_path(String homework_file_path) {
        this.homework_file_path = homework_file_path;
    }

    public String getHomework_file_name() {
        return homework_file_name;
    }

    public void setHomework_file_name(String homework_file_name) {
        this.homework_file_name = homework_file_name;
    }

    public String getIs_draft() {
        return is_draft;
    }

    public void setIs_draft(String is_draft) {
        this.is_draft = is_draft;
    }

    public Date getInsert_date() {
        return insert_date;
    }

    public void setInsert_date(Date insert_date) {
        this.insert_date = insert_date;
    }
}
