package com.xjtuse.summerproject.entity;

import java.io.Serializable;

public class DashBoardMenuInfo  implements Serializable {
    private String status;
    private String message;
    private String user_id;

    @Override
    public String toString() {
        return "DashBoardMenuInfo{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", user_id='" + user_id + '\'' +
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

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
