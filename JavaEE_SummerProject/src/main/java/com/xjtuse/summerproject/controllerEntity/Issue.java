package com.xjtuse.summerproject.controllerEntity;

import java.io.Serializable;
import java.sql.Date;

public class Issue implements Serializable {
    private String id;
    private String value;
    private String issue_id_path;
    private String course;
    private String deadline;
    private String content;
    private String status;

    @Override
    public String toString() {
        return "Issue{" +
                "id='" + id + '\'' +
                ", value='" + value + '\'' +
                ", issue_id_path='" + issue_id_path + '\'' +
                ", course='" + course + '\'' +
                ", deadline='" + deadline + '\'' +
                ", content='" + content + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getIssue_id_path() {
        return issue_id_path;
    }

    public void setIssue_id_path(String issue_id_path) {
        this.issue_id_path = issue_id_path;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
