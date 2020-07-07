package com.xjtuse.summerproject.mapper;

import com.xjtuse.summerproject.controllerEntity.Issue;
import com.xjtuse.summerproject.entity.Temp;
import org.apache.ibatis.annotations.Select;

public interface IssueMapper {
    @Select("call test_mytest(#{course_id}, #{announcement_id})")
    Issue findIssue(Temp temp);
}
