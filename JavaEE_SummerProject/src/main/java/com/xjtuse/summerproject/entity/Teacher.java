package com.xjtuse.summerproject.entity;

import java.io.Serializable;
import java.sql.Date;

public class Teacher implements Serializable {
    private String teacher_name;
    private String teacher_id;
    private String teacher_age;
    private String teacher_email;
    private String teacher_gender;
    private String teacher_phone;
    private String teacher_content;
    private String teacher_username;
    private String teacher_password;
    private Date insert_date;

    @Override
    public String toString() {
        return "Teacher{" +
                "teacher_name='" + teacher_name + '\'' +
                ", teacher_id='" + teacher_id + '\'' +
                ", teacher_age='" + teacher_age + '\'' +
                ", teacher_email='" + teacher_email + '\'' +
                ", teacher_gender='" + teacher_gender + '\'' +
                ", teacher_phone='" + teacher_phone + '\'' +
                ", teacher_content='" + teacher_content + '\'' +
                ", teacher_username='" + teacher_username + '\'' +
                ", teacher_password='" + teacher_password + '\'' +
                ", insert_date=" + insert_date +
                '}';
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getTeacher_age() {
        return teacher_age;
    }

    public void setTeacher_age(String teacher_age) {
        this.teacher_age = teacher_age;
    }

    public String getTeacher_email() {
        return teacher_email;
    }

    public void setTeacher_email(String teacher_email) {
        this.teacher_email = teacher_email;
    }

    public String getTeacher_gender() {
        return teacher_gender;
    }

    public void setTeacher_gender(String teacher_gender) {
        this.teacher_gender = teacher_gender;
    }

    public String getTeacher_phone() {
        return teacher_phone;
    }

    public void setTeacher_phone(String teacher_phone) {
        this.teacher_phone = teacher_phone;
    }

    public String getTeacher_content() {
        return teacher_content;
    }

    public void setTeacher_content(String teacher_content) {
        this.teacher_content = teacher_content;
    }

    public String getTeacher_username() {
        return teacher_username;
    }

    public void setTeacher_username(String teacher_username) {
        this.teacher_username = teacher_username;
    }

    public String getTeacher_password() {
        return teacher_password;
    }

    public void setTeacher_password(String teacher_password) {
        this.teacher_password = teacher_password;
    }

    public Date getInsert_date() {
        return insert_date;
    }

    public void setInsert_date(Date insert_date) {
        this.insert_date = insert_date;
    }
}
