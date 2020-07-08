package com.xjtuse.summerproject.controllerEntity;

import java.io.Serializable;

public class ResponseInfo implements Serializable {
    private String success_value;
    private String role;
    private String role_id;
    private String fail_content;

    @Override
    public String toString() {
        return "ResponseInfo{" +
                "success_value='" + success_value + '\'' +
                ", role='" + role + '\'' +
                ", role_id='" + role_id + '\'' +
                ", fail_content='" + fail_content + '\'' +
                '}';
    }

    public String getSuccess_value() {
        return success_value;
    }

    public void setSuccess_value(String success_value) {
        this.success_value = success_value;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public String getFail_content() {
        return fail_content;
    }

    public void setFail_content(String fail_content) {
        this.fail_content = fail_content;
    }
}
