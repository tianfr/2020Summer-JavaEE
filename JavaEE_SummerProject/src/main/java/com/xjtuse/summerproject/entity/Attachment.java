package com.xjtuse.summerproject.entity;

import java.io.Serializable;

public class Attachment implements Serializable {
    private String attachment_path;
    private String attachment_name;

    @Override
    public String toString() {
        return "Attachment{" +
                "attachment_path='" + attachment_path + '\'' +
                ", attachment_name='" + attachment_name + '\'' +
                '}';
    }

    public String getAttachment_path() {
        return attachment_path;
    }

    public void setAttachment_path(String attachment_path) {
        this.attachment_path = attachment_path;
    }

    public String getAttachment_name() {
        return attachment_name;
    }

    public void setAttachment_name(String attachment_name) {
        this.attachment_name = attachment_name;
    }
}
