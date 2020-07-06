package com.xjtuse.summerproject.controllerEntity;

import java.io.Serializable;

public class Announcement implements Serializable {
    private String announcement_title;
    private String author;
    private String author_email;
    private String author_avatar;
    private String announcement_content;
    private String datetime;

    @Override
    public String toString() {
        return "Announcement{" +
                "announcement_title='" + announcement_title + '\'' +
                ", author='" + author + '\'' +
                ", author_email='" + author_email + '\'' +
                ", author_avatar='" + author_avatar + '\'' +
                ", announcement_content='" + announcement_content + '\'' +
                ", datetime='" + datetime + '\'' +
                '}';
    }

    public String getAnnouncement_title() {
        return announcement_title;
    }

    public void setAnnouncement_title(String announcement_title) {
        this.announcement_title = announcement_title;
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

    public String getAnnouncement_content() {
        return announcement_content;
    }

    public void setAnnouncement_content(String announcement_content) {
        this.announcement_content = announcement_content;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
}
