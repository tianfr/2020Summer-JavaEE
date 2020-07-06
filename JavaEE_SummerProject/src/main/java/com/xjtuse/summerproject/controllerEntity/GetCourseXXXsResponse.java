package com.xjtuse.summerproject.controllerEntity;

import java.io.Serializable;
import java.util.List;

public class GetCourseXXXsResponse implements Serializable {
    private String id;
    private Integer total_num;
    private List<Object> value;

    @Override
    public String toString() {
        return "GetCourseXXXsResponse{" +
                "id='" + id + '\'' +
                ", total_num=" + total_num +
                ", value=" + value +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getTotal_num() {
        return total_num;
    }

    public void setTotal_num(Integer total_num) {
        this.total_num = total_num;
    }

    public List<Object> getValue() {
        return value;
    }

    public void setValue(List<Object> value) {
        this.value = value;
    }
}
