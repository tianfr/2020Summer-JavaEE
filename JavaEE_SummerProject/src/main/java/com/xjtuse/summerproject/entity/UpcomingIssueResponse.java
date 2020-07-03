package com.xjtuse.summerproject.entity;

import java.io.Serializable;
import java.util.List;

public class UpcomingIssueResponse implements Serializable {
    private String id;
    private List<Issue> value;

    @Override
    public String toString() {
        return "UpcomingIssueResponse{" +
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

    public List<Issue> getValue() {
        return value;
    }

    public void setValue(List<Issue> value) {
        this.value = value;
    }
}
