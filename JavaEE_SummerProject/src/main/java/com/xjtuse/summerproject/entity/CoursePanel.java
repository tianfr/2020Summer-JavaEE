package com.xjtuse.summerproject.entity;

import java.io.Serializable;

public class CoursePanel implements Serializable {
    private String panel_id;
    private String panel_name;

    @Override
    public String toString() {
        return "CoursePanel{" +
                "panel_id='" + panel_id + '\'' +
                ", panel_name='" + panel_name + '\'' +
                '}';
    }

    public String getPanel_id() {
        return panel_id;
    }

    public void setPanel_id(String panel_id) {
        this.panel_id = panel_id;
    }

    public String getPanel_name() {
        return panel_name;
    }

    public void setPanel_name(String panel_name) {
        this.panel_name = panel_name;
    }
}
