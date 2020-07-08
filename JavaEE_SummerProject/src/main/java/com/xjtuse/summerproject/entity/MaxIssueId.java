package com.xjtuse.summerproject.entity;

public class MaxIssueId {
    // This class is used for StudentMapper 6.16 to get Max issue_id
    private String course_id;
    private String issue_type;

    @Override
    public String toString() {
        return "MaxIssueId{" +
                "course_id='" + course_id + '\'' +
                ", issue_type='" + issue_type + '\'' +
                '}';
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getIssue_type() {
        return issue_type;
    }

    public void setIssue_type(String issue_type) {
        this.issue_type = issue_type;
    }
}
