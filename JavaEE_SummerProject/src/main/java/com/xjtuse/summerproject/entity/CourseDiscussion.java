package com.xjtuse.summerproject.entity;

import java.sql.Date;

public class CourseDiscussion {
    private String discussion_id;
    private String response_id;
    private String student_id;
    private String theme;
    private String parent_discussion_id;
    private String content;
    private Date insert_date;

    @Override
    public String toString() {
        return "CourseDiscussion{" +
                "discussion_id='" + discussion_id + '\'' +
                ", response_id='" + response_id + '\'' +
                ", student_id='" + student_id + '\'' +
                ", theme='" + theme + '\'' +
                ", parent_discussion_id='" + parent_discussion_id + '\'' +
                ", content='" + content + '\'' +
                ", insert_date=" + insert_date +
                '}';
    }

    public String getDiscussion_id() {
        return discussion_id;
    }

    public void setDiscussion_id(String discussion_id) {
        this.discussion_id = discussion_id;
    }

    public String getResponse_id() {
        return response_id;
    }

    public void setResponse_id(String response_id) {
        this.response_id = response_id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getParent_discussion_id() {
        return parent_discussion_id;
    }

    public void setParent_discussion_id(String parent_discussion_id) {
        this.parent_discussion_id = parent_discussion_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getInsert_date() {
        return insert_date;
    }

    public void setInsert_date(Date insert_date) {
        this.insert_date = insert_date;
    }
}
