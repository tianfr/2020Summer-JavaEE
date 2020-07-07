package com.xjtuse.summerproject.entity;

import java.sql.Date;

public class CourseExamination {

    private String student_id;
    private String exam_id;
    private Date submitted_date;
    private String content_path;
    private Date insert_date;

    @Override
    public String toString() {
        return "CourseExamination{" +
                "student_id='" + student_id + '\'' +
                ", exam_id='" + exam_id + '\'' +
                ", submitted_date=" + submitted_date +
                ", content_path='" + content_path + '\'' +
                ", insert_date=" + insert_date +
                '}';
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getExam_id() {
        return exam_id;
    }

    public void setExam_id(String exam_id) {
        this.exam_id = exam_id;
    }

    public Date getSubmitted_date() {
        return submitted_date;
    }

    public void setSubmitted_date(Date submitted_date) {
        this.submitted_date = submitted_date;
    }

    public String getContent_path() {
        return content_path;
    }

    public void setContent_path(String content_path) {
        this.content_path = content_path;
    }

    public Date getInsert_date() {
        return insert_date;
    }

    public void setInsert_date(Date insert_date) {
        this.insert_date = insert_date;
    }
}
