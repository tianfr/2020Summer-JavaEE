package com.xjtuse.summerproject.controllerEntity;

import java.sql.Date;

public class GetStudentHomeworksResponseSub {
    private String student_id;
    private String homework_title;
    private String homework_content;
    private String homework_file_name;
    private String homework_file_path;
    private String insert_date;

    @Override
    public String toString() {
        return "GetStudentHomeworksResponseSub{" +
                "student_id='" + student_id + '\'' +
                ", homework_title='" + homework_title + '\'' +
                ", homework_content='" + homework_content + '\'' +
                ", homework_file_name='" + homework_file_name + '\'' +
                ", homework_file_path='" + homework_file_path + '\'' +
                ", insert_date='" + insert_date + '\'' +
                '}';
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getHomework_title() {
        return homework_title;
    }

    public void setHomework_title(String homework_title) {
        this.homework_title = homework_title;
    }

    public String getHomework_content() {
        return homework_content;
    }

    public void setHomework_content(String homework_content) {
        this.homework_content = homework_content;
    }

    public String getHomework_file_name() {
        return homework_file_name;
    }

    public void setHomework_file_name(String homework_file_name) {
        this.homework_file_name = homework_file_name;
    }

    public String getHomework_file_path() {
        return homework_file_path;
    }

    public void setHomework_file_path(String homework_file_path) {
        this.homework_file_path = homework_file_path;
    }

    public String getInsert_date() {
        return insert_date;
    }

    public void setInsert_date(String insert_date) {
        this.insert_date = insert_date;
    }
}
