package com.xjtuse.summerproject.controllerEntity;

public class UpdateHomeworkInfo {
    private String course_id;
    private String content;
    private String homework_file_path;
    private String homework_file_name;
    private String insert_date;
    private String student_id;
    private String homework_id;

    @Override
    public String toString() {
        return "UpdateHomeworkInfo{" +
                "course_id='" + course_id + '\'' +
                ", content='" + content + '\'' +
                ", homework_file_path='" + homework_file_path + '\'' +
                ", homework_file_name='" + homework_file_name + '\'' +
                ", insert_date='" + insert_date + '\'' +
                ", student_id='" + student_id + '\'' +
                ", homework_id='" + homework_id + '\'' +
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

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
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

    public String getInsert_date() {
        return insert_date;
    }

    public void setInsert_date(String insert_date) {
        this.insert_date = insert_date;
    }
}
