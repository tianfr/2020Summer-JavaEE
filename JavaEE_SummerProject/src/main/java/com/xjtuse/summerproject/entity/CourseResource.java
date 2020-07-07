package com.xjtuse.summerproject.entity;

import java.sql.Date;

public class CourseResource {
    private String resource_id;
    private String resource_type;
    private String resource_name;
    private String resource_path;
    private String resource_belong;
    private Date insert_date;

    @Override
    public String toString() {
        return "CourseResource{" +
                "resource_id='" + resource_id + '\'' +
                ", resource_type='" + resource_type + '\'' +
                ", resource_name='" + resource_name + '\'' +
                ", resource_path='" + resource_path + '\'' +
                ", resource_belong='" + resource_belong + '\'' +
                ", insert_date=" + insert_date +
                '}';
    }

    public String getResource_id() {
        return resource_id;
    }

    public void setResource_id(String resource_id) {
        this.resource_id = resource_id;
    }

    public String getResource_type() {
        return resource_type;
    }

    public void setResource_type(String resource_type) {
        this.resource_type = resource_type;
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

    public String getResource_belong() {
        return resource_belong;
    }

    public void setResource_belong(String resource_belong) {
        this.resource_belong = resource_belong;
    }

    public Date getInsert_date() {
        return insert_date;
    }

    public void setInsert_date(Date insert_date) {
        this.insert_date = insert_date;
    }
}
