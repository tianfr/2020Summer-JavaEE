package com.xjtuse.summerproject.entity;

import java.io.Serializable;
import java.util.List;

public class RecentInfoResponse implements Serializable {
    private String id;
    private List<RecentInfo> value;

    @Override
    public String toString() {
        return "RecentInfoResponse{" +
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

    public List<RecentInfo> getValue() {
        return value;
    }

    public void setValue(List<RecentInfo> value) {
        this.value = value;
    }
}
