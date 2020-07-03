package com.xjtuse.summerproject.entity;

import java.io.Serializable;

public class RecentInfo implements Serializable {
    private String id;
    private String value;
    private String info_id_path;
    private String course;
    private String datetime;
    private String content;

    @Override
    public String toString() {
        return "RecentInfo{" +
                "id='" + id + '\'' +
                ", value='" + value + '\'' +
                ", info_id_path='" + info_id_path + '\'' +
                ", course='" + course + '\'' +
                ", datetime='" + datetime + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getInfo_id_path() {
        return info_id_path;
    }

    public void setInfo_id_path(String info_id_path) {
        this.info_id_path = info_id_path;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
