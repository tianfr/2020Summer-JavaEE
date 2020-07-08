package com.xjtuse.summerproject.mapper;

import com.xjtuse.summerproject.entity.CourseHomework;
import com.xjtuse.summerproject.entity.SendHomework;
import com.xjtuse.summerproject.entity.Student;
import com.xjtuse.summerproject.entity.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface TeacherMapper {

    @Select("select * from teachers where teacher_username=#{teacher_username}")
    Teacher findByUsername(String teacher_username);

    @Select("select max(teacher_id) from teachers")
    String findMaxId();

    @Insert("insert into teachers(teacher_id, teacher_name, teacher_age, teacher_email, teacher_gender, teacher_phone, teacher_content, teacher_username, teacher_password, insert_date) values(#{teacher_id}, #{teacher_name}, #{teacher_age}, #{teacher_email}, #{teacher_gender}, #{teacher_phone}, #{teacher_content}, #{teacher_username}, #{teacher_password}, #{insert_date}) ")
    void insertTeacher(Teacher teacher);

    //修改密码
    @Update("update teachers set teacher_password=#{teacher_password} where teacher_username=#{teacher_username}")
    void updateTeacherPasswordByUsername(Teacher teacher);

    //6.18 老师查看所有已提交作业
    @Select("SELECT * FROM course_${course_id}_homework WHERE homework_id = #{homework_id} AND is_draft = 'no';")
    List<CourseHomework> getStudentHomeworks(SendHomework sendHomework);

}
