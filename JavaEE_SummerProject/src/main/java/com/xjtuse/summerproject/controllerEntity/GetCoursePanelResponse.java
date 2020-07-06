package com.xjtuse.summerproject.controllerEntity;

import java.io.Serializable;
import java.util.List;

public class GetCoursePanelResponse implements Serializable {
    private String id;
    private List<CoursePanel> value;

    @Override
    public String toString() {
        return "GetCoursePanelResponse{" +
                "id='" + id + '\'' +
                ", value=" + value +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<CoursePanel> getValue() {
        return value;
    }

    public void setValue(List<CoursePanel> value) {
        this.value = value;
    }
}
