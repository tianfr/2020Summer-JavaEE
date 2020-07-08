package com.xjtuse.summerproject.controllerEntity;

public class GetPrevCoursesSubResponse {
    private String course_title;
    private String course_teacher;
    private String course_hierarchy;
    private String course_college;
    private String course_id;

    @Override
    public String toString() {
        return "GetPrevCoursesSubResponse{" +
                "course_title='" + course_title + '\'' +
                ", course_teacher='" + course_teacher + '\'' +
                ", course_hierarchy='" + course_hierarchy + '\'' +
                ", course_college='" + course_college + '\'' +
                ", course_id='" + course_id + '\'' +
                '}';
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getCourse_title() {
        return course_title;
    }

    public void setCourse_title(String course_title) {
        this.course_title = course_title;
    }

    public String getCourse_teacher() {
        return course_teacher;
    }

    public void setCourse_teacher(String course_teacher) {
        this.course_teacher = course_teacher;
    }

    public String getCourse_hierarchy() {
        return course_hierarchy;
    }

    public void setCourse_hierarchy(String course_hierarchy) {
        this.course_hierarchy = course_hierarchy;
    }

    public String getCourse_college() {
        return course_college;
    }

    public void setCourse_college(String course_college) {
        this.course_college = course_college;
    }
}
