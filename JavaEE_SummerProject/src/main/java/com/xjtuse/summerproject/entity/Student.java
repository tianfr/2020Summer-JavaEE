package com.xjtuse.summerproject.entity;

import java.io.Serializable;
import java.sql.Date;

public class Student implements Serializable {
    private String student_id;
    private String student_name;
    private String student_age;
    private String student_gender;
    private String student_class;
    private String student_email;
    private String student_username;
    private String student_password;
    private Date insert_date;
    private String student_avatar;

    @Override
    public String toString() {
        return "Student{" +
                "student_id='" + student_id + '\'' +
                ", student_name='" + student_name + '\'' +
                ", student_age='" + student_age + '\'' +
                ", student_gender='" + student_gender + '\'' +
                ", student_class='" + student_class + '\'' +
                ", student_email='" + student_email + '\'' +
                ", student_username='" + student_username + '\'' +
                ", student_password='" + student_password + '\'' +
                ", insert_date=" + insert_date +
                ", student_avatar='" + student_avatar + '\'' +
                '}';
    }

    public String getStudent_avatar() {
        return student_avatar;
    }

    public void setStudent_avatar(String student_avatar) {
        this.student_avatar = student_avatar;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_age() {
        return student_age;
    }

    public void setStudent_age(String student_age) {
        this.student_age = student_age;
    }

    public String getStudent_gender() {
        return student_gender;
    }

    public void setStudent_gender(String student_gender) {
        this.student_gender = student_gender;
    }

    public String getStudent_class() {
        return student_class;
    }

    public void setStudent_class(String student_class) {
        this.student_class = student_class;
    }

    public String getStudent_email() {
        return student_email;
    }

    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }

    public String getStudent_username() {
        return student_username;
    }

    public void setStudent_username(String student_username) {
        this.student_username = student_username;
    }

    public String getStudent_password() {
        return student_password;
    }

    public void setStudent_password(String student_password) {
        this.student_password = student_password;
    }

    public Date getInsert_date() {
        return insert_date;
    }

    public void setInsert_date(Date insert_date) {
        this.insert_date = insert_date;
    }

}
