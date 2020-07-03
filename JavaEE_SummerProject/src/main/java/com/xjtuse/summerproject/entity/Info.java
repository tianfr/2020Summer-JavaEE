package com.xjtuse.summerproject.entity;

import java.io.Serializable;

public class Info implements Serializable {
    private String status;
    private String message;

    @Override
    public String toString() {
        return "Info{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
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
}
