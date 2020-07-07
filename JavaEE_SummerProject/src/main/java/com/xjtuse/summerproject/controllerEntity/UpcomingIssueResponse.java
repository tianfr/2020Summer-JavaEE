package com.xjtuse.summerproject.controllerEntity;

import java.io.Serializable;
import java.util.List;

public class UpcomingIssueResponse implements Serializable {
    private String id;
    private Integer total_num;
    private List<Issue> value;

    @Override
    public String toString() {
        return "UpcomingIssueResponse{" +
                "id='" + id + '\'' +
                ", total_num=" + total_num +
                ", value=" + value +
                '}';
    }

    public Integer getTotal_num() {
        return total_num;
    }

    public void setTotal_num(Integer total_num) {
        this.total_num = total_num;
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
