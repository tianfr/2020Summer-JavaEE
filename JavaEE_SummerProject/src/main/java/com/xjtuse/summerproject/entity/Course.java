package com.xjtuse.summerproject.entity;

import java.io.Serializable;

public class Course implements Serializable {
    private String id;
    private String course_name;
    private String course_path;

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", course_name='" + course_name + '\'' +
                ", course_path='" + course_path + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_path() {
        return course_path;
    }

    public void setCourse_path(String course_path) {
        this.course_path = course_path;
    }
}
