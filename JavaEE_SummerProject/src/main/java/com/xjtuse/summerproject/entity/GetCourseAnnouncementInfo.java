package com.xjtuse.summerproject.entity;

public class GetCourseAnnouncementInfo {
    private String status;
    private String message;
    private String course;

    @Override
    public String toString() {
        return "GetCourseAnnouncementInfo{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", course='" + course + '\'' +
                '}';
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
