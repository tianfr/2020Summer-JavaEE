package com.xjtuse.summerproject.entity;

import java.io.Serializable;
import java.util.List;

public class GetCourseAnnouncementResponse implements Serializable {
    private String id;
    private Integer total_num;
    private List<CourseAnnouncement> value;

    @Override
    public String toString() {
        return "GetCourseAnnouncementResponse{" +
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

    public List<CourseAnnouncement> getValue() {
        return value;
    }

    public void setValue(List<CourseAnnouncement> value) {
        this.value = value;
    }
}
