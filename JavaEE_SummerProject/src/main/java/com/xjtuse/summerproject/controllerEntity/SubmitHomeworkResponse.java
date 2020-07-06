package com.xjtuse.summerproject.controllerEntity;

import java.io.Serializable;

public class SubmitHomeworkResponse implements Serializable {
    private String success_value;
    private String datetime;
    private String fail_content;

    @Override
    public String toString() {
        return "SubmitHomeworkResponse{" +
                "success_value='" + success_value + '\'' +
                ", datetime='" + datetime + '\'' +
                ", fail_content='" + fail_content + '\'' +
                '}';
    }

    public String getSuccess_value() {
        return success_value;
    }

    public void setSuccess_value(String success_value) {
        this.success_value = success_value;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getFail_content() {
        return fail_content;
    }

    public void setFail_content(String fail_content) {
        this.fail_content = fail_content;
    }
}
