package com.xjtuse.summerproject.entity;

import java.io.Serializable;
import java.util.List;

public class LoginInfo implements Serializable {
    private String status;
    private String message;
    private String user_name;
    private String pass_word;

    @Override
    public String toString() {
        return "LoginInfo{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", user_name='" + user_name + '\'' +
                ", pass_word='" + pass_word + '\'' +
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
}
