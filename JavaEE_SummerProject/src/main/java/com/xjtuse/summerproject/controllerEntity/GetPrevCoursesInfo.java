package com.xjtuse.summerproject.controllerEntity;

public class GetPrevCoursesInfo {
    private String status;
    private String message;
    private String role;
    private String person_id;

    @Override
    public String toString() {
        return "GetPrevCoursesInfo{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", role='" + role + '\'' +
                ", person_id='" + person_id + '\'' +
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPerson_id() {
        return person_id;
    }

    public void setPerson_id(String person_id) {
        this.person_id = person_id;
    }
}
