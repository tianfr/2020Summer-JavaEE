package com.xjtuse.summerproject.controllerEntity;

import java.io.Serializable;

public class RegisterInfo implements Serializable {
    private String status;
    private String message;
    private String user_name;
    private String pass_word;
    private String email;
    private String full_name;

    @Override
    public String toString() {
        return "RegisterInfo{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", user_name='" + user_name + '\'' +
                ", pass_word='" + pass_word + '\'' +
                ", email='" + email + '\'' +
                ", full_name='" + full_name + '\'' +
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

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPass_word() {
        return pass_word;
    }

    public void setPass_word(String pass_word) {
        this.pass_word = pass_word;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
}
