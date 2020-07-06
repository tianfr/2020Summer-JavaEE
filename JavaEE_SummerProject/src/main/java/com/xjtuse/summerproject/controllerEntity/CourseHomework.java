package com.xjtuse.summerproject.controllerEntity;

import java.io.Serializable;

public class CourseHomework implements Serializable {
    private String homework_title;
    private String homework_id;
    private String homework_content;
    private String homework_deadline;

    @Override
    public String toString() {
        return "CourseHomework{" +
                "homework_title='" + homework_title + '\'' +
                ", homework_id='" + homework_id + '\'' +
                ", homework_content='" + homework_content + '\'' +
                ", homework_deadline='" + homework_deadline + '\'' +
                '}';
    }

    public String getHomework_title() {
        return homework_title;
    }

    public void setHomework_title(String homework_title) {
        this.homework_title = homework_title;
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

    public String getHomework_deadline() {
        return homework_deadline;
    }

    public void setHomework_deadline(String homework_deadline) {
        this.homework_deadline = homework_deadline;
    }
}
