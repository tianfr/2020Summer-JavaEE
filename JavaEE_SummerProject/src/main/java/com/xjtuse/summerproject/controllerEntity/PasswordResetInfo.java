package com.xjtuse.summerproject.controllerEntity;

import java.io.Serializable;

public class PasswordResetInfo implements Serializable {
    private String key;
    private String password;

    @Override
    public String toString() {
        return "PasswordResetInfo{" +
                "key='" + key + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
