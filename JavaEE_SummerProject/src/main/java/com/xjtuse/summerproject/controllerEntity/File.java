package com.xjtuse.summerproject.controllerEntity;

import java.io.Serializable;

public class File implements Serializable {
    private String file_name;
    private String file_path;

    @Override
    public String toString() {
        return "File{" +
                "file_name='" + file_name + '\'' +
                ", file_path='" + file_path + '\'' +
                '}';
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }
}
