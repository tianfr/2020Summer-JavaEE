package com.xjtuse.summerproject.controllerEntity;

import java.util.List;

public class GetStudentHomeworksResponse {
    private Integer total_num;
    private List<GetStudentHomeworksResponseSub> homeworks;

    @Override
    public String toString() {
        return "GetStudentHomeworksResponse{" +
                "total_num=" + total_num +
                ", homeworks=" + homeworks +
                '}';
    }

    public Integer getTotal_num() {
        return total_num;
    }

    public void setTotal_num(Integer total_num) {
        this.total_num = total_num;
    }

    public List<GetStudentHomeworksResponseSub> getHomeworks() {
        return homeworks;
    }

    public void setHomeworks(List<GetStudentHomeworksResponseSub> homeworks) {
        this.homeworks = homeworks;
    }
}
