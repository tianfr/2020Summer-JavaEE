package com.xjtuse.summerproject.controllerEntity;

import java.io.Serializable;

public class PasswordReminderInfo implements Serializable {
    private String status;
    private String message;
    private String username;
    private String email;

    @Override
    public String toString() {
        return "PasswordReminderInfo{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
