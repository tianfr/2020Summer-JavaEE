package com.xjtuse.summerproject.controllerEntity;

import java.io.Serializable;
import java.util.List;

public class GetHomeworkResponse implements Serializable {
    private String homework_title;
    private String author;
    private String author_email;
    private String author_avatar;
    private String deadline;
    private String homework_content;
    private List<Attachment> homework_attachment;
    private String datetime;

    @Override
    public String toString() {
        return "GetHomeworkResponse{" +
                "homework_title='" + homework_title + '\'' +
                ", author='" + author + '\'' +
                ", author_email='" + author_email + '\'' +
                ", author_avatar='" + author_avatar + '\'' +
                ", deadline='" + deadline + '\'' +
                ", homework_content='" + homework_content + '\'' +
                ", homework_attachment=" + homework_attachment +
                ", datetime='" + datetime + '\'' +
                '}';
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getHomework_title() {
        return homework_title;
    }

    public void setHomework_title(String homework_title) {
        this.homework_title = homework_title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor_email() {
        return author_email;
    }

    public void setAuthor_email(String author_email) {
        this.author_email = author_email;
    }

    public String getAuthor_avatar() {
        return author_avatar;
    }

    public void setAuthor_avatar(String author_avatar) {
        this.author_avatar = author_avatar;
    }

    public String getHomework_content() {
        return homework_content;
    }

    public void setHomework_content(String homework_content) {
        this.homework_content = homework_content;
    }

    public List<Attachment> getHomework_attachment() {
        return homework_attachment;
    }

    public void setHomework_attachment(List<Attachment> homework_attachment) {
        this.homework_attachment = homework_attachment;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
}
