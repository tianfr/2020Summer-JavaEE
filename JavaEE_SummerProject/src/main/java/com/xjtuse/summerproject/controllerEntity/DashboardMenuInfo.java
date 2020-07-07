package com.xjtuse.summerproject.controllerEntity;

import java.io.Serializable;

public class DashboardMenuInfo implements Serializable {
    private String status;
    private String message;

    @Override
    public String toString() {
        return "DashboardMenuInfo{" +
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
