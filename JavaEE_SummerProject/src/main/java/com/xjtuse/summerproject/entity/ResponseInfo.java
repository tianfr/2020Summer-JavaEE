package com.xjtuse.summerproject.entity;

import java.io.Serializable;

public class ResponseInfo implements Serializable {
    private String success_value;
    private String fail_content;

    @Override
    public String toString() {
        return "LoginResponse{" +
                "success_value='" + success_value + '\'' +
                ", fail_content='" + fail_content + '\'' +
                '}';
    }

    public String getSuccess_value() {
        return success_value;
    }

    public void setSuccess_value(String success_value) {
        this.success_value = success_value;
    }

    public String getFail_content() {
        return fail_content;
    }

    public void setFail_content(String fail_content) {
        this.fail_content = fail_content;
    }
}
