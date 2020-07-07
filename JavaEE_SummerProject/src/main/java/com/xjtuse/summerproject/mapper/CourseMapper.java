package com.xjtuse.summerproject.mapper;

import com.xjtuse.summerproject.entity.CourseContent;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CourseMapper {
    //查询课程对应的course_content_table内容
    @Select("SELECT * FROM ${str} WHERE issue_type != 'homework' AND issue_type != 'examination'" )
    List<CourseContent> findUpcomingIssue(String str);

}
