package com.xjtuse.summerproject.entity;

import java.io.Serializable;
import java.sql.Date;

public class CourseContent implements Serializable {
    private String course_id = "None";
    private String issue_id;
    private String issue_type;
    private String issue_title;
    private String issue_content;
    private String issue_attachment_name;
    private String issue_attachment_path;
    private Date issue_deadline;
    private String issue_table;
    private String issue_belong;
    private Date insert_date;

    public void updateIssueId(String issue_id){
        Integer number = Integer.valueOf(issue_id.substring(issue_id.length()-3, issue_id.length()));
        this.issue_id = issue_id.substring(0, issue_id.length()-3) + Integer.toString(number + 1);
        System.out.println(this.issue_id);
    }

    @Override
    public String toString() {
        return "CourseContent{" +
                "course_id='" + course_id + '\'' +
                ", issue_id='" + issue_id + '\'' +
                ", issue_type='" + issue_type + '\'' +
                ", issue_title='" + issue_title + '\'' +
                ", issue_content='" + issue_content + '\'' +
                ", issue_attachment_name='" + issue_attachment_name + '\'' +
                ", issue_attachment_path='" + issue_attachment_path + '\'' +
                ", issue_deadline=" + issue_deadline +
                ", issue_table='" + issue_table + '\'' +
                ", issue_belong='" + issue_belong + '\'' +
                ", insert_date=" + insert_date +
                '}';
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getIssue_id() {
        return issue_id;
    }

    public void setIssue_id(String issue_id) {
        this.issue_id = issue_id;
    }

    public String getIssue_type() {
        return issue_type;
    }

    public void setIssue_type(String issue_type) {
        this.issue_type = issue_type;
    }

    public String getIssue_title() {
        return issue_title;
    }

    public void setIssue_title(String issue_title) {
        this.issue_title = issue_title;
    }

    public String getIssue_content() {
        return issue_content;
    }

    public void setIssue_content(String issue_content) {
        this.issue_content = issue_content;
    }

    public String getIssue_attachment_name() {
        return issue_attachment_name;
    }

    public void setIssue_attachment_name(String issue_attachment_name) {
        this.issue_attachment_name = issue_attachment_name;
    }

    public String getIssue_attachment_path() {
        return issue_attachment_path;
    }

    public void setIssue_attachment_path(String issue_attachment_path) {
        this.issue_attachment_path = issue_attachment_path;
    }

    public Date getIssue_deadline() {
        return issue_deadline;
    }

    public void setIssue_deadline(Date issue_deadline) {
        this.issue_deadline = issue_deadline;
    }

    public String getIssue_table() {
        return issue_table;
    }

    public void setIssue_table(String issue_table) {
        this.issue_table = issue_table;
    }

    public String getIssue_belong() {
        return issue_belong;
    }

    public void setIssue_belong(String issue_belong) {
        this.issue_belong = issue_belong;
    }

    public Date getInsert_date() {
        return insert_date;
    }

    public void setInsert_date(Date insert_date) {
        this.insert_date = insert_date;
    }
}
