package com.xjtuse.summerproject.entity;

import java.sql.Date;

public class CoursePanel {
    // This class is used for CoursePanel Mapper to get personalized settings of a course.

    private String design_id;
    private String design_name;
    private String design_table;
    private Date insert_date;

    @Override
    public String toString() {
        return "CoursePanel{" +
                "design_id='" + design_id + '\'' +
                ", design_name='" + design_name + '\'' +
                ", design_table='" + design_table + '\'' +
                ", insert_date=" + insert_date +
                '}';
    }

    public String getDesign_id() {
        return design_id;
    }

    public void setDesign_id(String design_id) {
        this.design_id = design_id;
    }

    public String getDesign_name() {
        return design_name;
    }

    public void setDesign_name(String design_name) {
        this.design_name = design_name;
    }

    public String getDesign_table() {
        return design_table;
    }

    public void setDesign_table(String design_table) {
        this.design_table = design_table;
    }

    public Date getInsert_date() {
        return insert_date;
    }

    public void setInsert_date(Date insert_date) {
        this.insert_date = insert_date;
    }
}
