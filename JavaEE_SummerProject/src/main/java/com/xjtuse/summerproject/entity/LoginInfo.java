package com.xjtuse.summerproject.entity;

import java.io.Serializable;
import java.util.List;

public class LoginInfo implements Serializable {
    private String status;
    private String message;
    private List<KeyValue> content;

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

    public List<KeyValue> getContent() {
        return content;
    }

    public void setContent(List<KeyValue> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "LoginInfo{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", content=" + content +
                '}';
    }
}
