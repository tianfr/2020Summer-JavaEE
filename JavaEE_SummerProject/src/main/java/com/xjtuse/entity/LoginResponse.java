package com.xjtuse.entity;

import java.io.Serializable;

public class LoginResponse implements Serializable {
    private String successvalue;
    private String failcontent;

    public String getSuccessvalue() {
        return successvalue;
    }

    public void setSuccessvalue(String successvalue) {
        this.successvalue = successvalue;
    }

    public String getFailcontent() {
        return failcontent;
    }

    public void setFailcontent(String failcontent) {
        this.failcontent = failcontent;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "successvalue='" + successvalue + '\'' +
                ", failcontent='" + failcontent + '\'' +
                '}';
    }
}
