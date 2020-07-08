package com.xjtuse.summerproject.controllerEntity;

import java.util.List;

public class GetPrevCoursesResponse {
    private String id = "prev_courses";
    private Integer total_num = 0;
    private List<GetPrevCoursesSubResponse> value;

    @Override
    public String toString() {
        return "GetPrevCoursesResponse{" +
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

    public List<GetPrevCoursesSubResponse> getValue() {
        return value;
    }

    public void setValue(List<GetPrevCoursesSubResponse> value) {
        this.value = value;
    }
}
