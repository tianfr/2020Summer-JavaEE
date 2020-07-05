package com.xjtuse.summerproject.entity;

import java.io.Serializable;

public class CourseResource implements Serializable {
    private String resource_name;
    private String resource_path;
    private Integer resource_size;
    private String resource_upload_time;
    private String resource_type;

    @Override
    public String toString() {
        return "CourseResource{" +
                "resource_name='" + resource_name + '\'' +
                ", resource_path='" + resource_path + '\'' +
                ", resource_size=" + resource_size +
                ", resource_upload_time='" + resource_upload_time + '\'' +
                ", resource_type='" + resource_type + '\'' +
                '}';
    }

    public String getResource_name() {
        return resource_name;
    }

    public void setResource_name(String resource_name) {
        this.resource_name = resource_name;
    }

    public String getResource_path() {
        return resource_path;
    }

    public void setResource_path(String resource_path) {
        this.resource_path = resource_path;
    }

    public Integer getResource_size() {
        return resource_size;
    }

    public void setResource_size(Integer resource_size) {
        this.resource_size = resource_size;
    }

    public String getResource_upload_time() {
        return resource_upload_time;
    }

    public void setResource_upload_time(String resource_upload_time) {
        this.resource_upload_time = resource_upload_time;
    }

    public String getResource_type() {
        return resource_type;
    }

    public void setResource_type(String resource_type) {
        this.resource_type = resource_type;
    }
}
