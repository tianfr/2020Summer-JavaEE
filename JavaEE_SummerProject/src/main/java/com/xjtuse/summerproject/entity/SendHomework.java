package com.xjtuse.summerproject.entity;

public class SendHomework {
    // A class for pushing para of Homework to get Homework details.
    private String course_id;
    private String homework_id;

    @Override
    public String toString() {
        return "SendHomework{" +
                "course_id='" + course_id + '\'' +
                ", homework_id='" + homework_id + '\'' +
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
}
