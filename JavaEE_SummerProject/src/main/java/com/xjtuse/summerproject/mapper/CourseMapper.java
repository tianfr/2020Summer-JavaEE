package com.xjtuse.summerproject.mapper;

import com.xjtuse.summerproject.controllerEntity.UpdateHomeworkInfo;
import com.xjtuse.summerproject.entity.Course;
import com.xjtuse.summerproject.entity.CourseContent;
import com.xjtuse.summerproject.entity.CourseHomework;
import com.xjtuse.summerproject.entity.CoursePanel;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

    @Select("SELECT * FROM course_${course_id}_homework WHERE student_id=#{student_id} and homework_id=#{homework_id}")
    CourseHomework getCourseHomework(UpdateHomeworkInfo updateHomeworkInfo);


    @Update("update course_${course_id}_homework set content=#{content}, homework_file_path=#{homework_file_path}, homework_file_name=#{homework_file_name}, is_draft='no', insert_date=#{insert_date} where student_id=#{student_id} and homework_id=#{homework_id}")
    void updateHomework(UpdateHomeworkInfo updateHomeworkInfo);

}
