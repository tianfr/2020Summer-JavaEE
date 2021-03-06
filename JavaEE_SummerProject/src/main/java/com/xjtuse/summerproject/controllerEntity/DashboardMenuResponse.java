package com.xjtuse.summerproject.controllerEntity;

import java.io.Serializable;
import java.util.List;

public class DashboardMenuResponse implements Serializable {
    private String avater;
    private String user_name;
    private String id;
    private String email;
    private List<Course> value;

    @Override
    public String toString() {
        return "DashboardMenuResponse{" +
                "avater='" + avater + '\'' +
                ", user_name='" + user_name + '\'' +
                ", id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", value=" + value +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvater() {
        return avater;
    }

    public void setAvater(String avater) {
        this.avater = avater;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Course> getValue() {
        return value;
    }

    public void setValue(List<Course> value) {
        this.value = value;
    }
}
