package com.xjtuse.summerproject.mapper;

import com.xjtuse.summerproject.entity.Course;
import com.xjtuse.summerproject.entity.CourseContent;
import com.xjtuse.summerproject.entity.CoursePanel;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CourseMapper {
    //查询课程对应的course_content_table内容
    @Select("SELECT * FROM ${str} WHERE issue_type != 'homework' AND issue_type != 'examination'" )
    List<CourseContent> findUpcomingIssue(String str);

    //6.7
    @Select("select * from ${str} where issue_type != 'homework' and issue_type != 'examination'")
    List<CourseContent> findRecentInfo(String str);
    @Select("SELECT * FROM course_${course_id}_design WHERE design_id NOT IN (\"announcement\", \"discussion\", \"examination\", \"homework\", \"resource\")")
    List<CoursePanel> getCoursePanel(String course_id);


}
