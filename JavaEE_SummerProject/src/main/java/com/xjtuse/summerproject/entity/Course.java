package com.xjtuse.summerproject.entity;

import java.io.Serializable;
import java.sql.Date;

public class Course implements Serializable {
    private String course_id;
    private String course_name;
    private String course_hierarchy;
    private String course_semester;
    private String course_design_table;
    private String course_content_table;
    private String course_college;

    @Override
    public String toString() {
        return "Course{" +
                "course_id='" + course_id + '\'' +
                ", course_name='" + course_name + '\'' +
                ", course_hierarchy='" + course_hierarchy + '\'' +
                ", course_semester='" + course_semester + '\'' +
                ", course_design_table='" + course_design_table + '\'' +
                ", course_content_table='" + course_content_table + '\'' +
                ", course_college='" + course_college + '\'' +
                ", insert_date=" + insert_date +
                '}';
    }

    public String getCourse_college() {
        return course_college;
    }

    public void setCourse_college(String course_college) {
        this.course_college = course_college;
    }

    private Date insert_date;

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_hierarchy() {
        return course_hierarchy;
    }

    public void setCourse_hierarchy(String course_hierarchy) {
        this.course_hierarchy = course_hierarchy;
    }

    public String getCourse_semester() {
        return course_semester;
    }

    public void setCourse_semester(String course_semester) {
        this.course_semester = course_semester;
    }

    public String getCourse_design_table() {
        return course_design_table;
    }

    public void setCourse_design_table(String course_design_table) {
        this.course_design_table = course_design_table;
    }

    public String getCourse_content_table() {
        return course_content_table;
    }

    public void setCourse_content_table(String course_content_table) {
        this.course_content_table = course_content_table;
    }

    public Date getInsert_date() {
        return insert_date;
    }

    public void setInsert_date(Date insert_date) {
        this.insert_date = insert_date;
    }
}
