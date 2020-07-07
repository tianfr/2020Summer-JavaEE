package com.xjtuse.summerproject.mapper;

import com.xjtuse.summerproject.entity.Course;
import com.xjtuse.summerproject.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

//用户的持久层接口
public interface StudentMapper {

    //查询所有学生
    @Select("select * from students")
    List<Student> findAll();

    //查询学生的课程
    @Select("select *  from courses where courses.course_id IN ( \n" +
            "        SELECT \n" +
            "            students_courses.course_id \n" +
            "        FROM \n" +
            "            students_courses \n" +
            "        WHERE \n" +
            "            student_id = #{student_id} \n" +
            "    )")
    List<Course> findAllCourseById(String student_id);


    //修改密码
    @Update("update students set student_password=#{student_password} where student_username=#{student_username}")
    void updateStudentPasswordByUsername(Student student);


    //插入学生
    @Insert("insert into students(student_id, student_name, student_age, student_gender, student_class, student_email, student_username, student_password, insert_date) values(#{student_id}, #{student_name}, #{student_age}, #{student_gender}, #{student_class}, #{student_email}, #{student_username}, #{student_password}, #{insert_date}) ")
    void insertStudent(Student student);

    //更新学生信息
    @Update("update students set student_name=#{student_name}, student_age=#{student_age}, student_gender=#{student_gender}, student_class=#{student_class}, student_email=#{student_email}, student_username=#{student_username}, student_password=#{student_password}, insert_date=#{insert_date} where student_id=#{student_id}")
    void updateStudent(Student student);

    //删除学生
    @Delete("delete from students where student_id=#{student_id}")
    void deleteStudent(String student_id);

    //根据学号查找学生
    @Select("select * from students where student_id=#{student_id}")
    Student findById(String student_id);

    //根据学号查找学生
    @Select("select * from students where student_username=#{student_username}")
    Student findByUsername(String student_username);

    //根据姓名模糊查询
    @Select("select * from students where student_name like #{name}")
    List<Student> findByName(String name);

    //查询学生总数
    @Select("select count(*) from students")
    Integer findTotal();

    //查询最大学号
    @Select("select max(student_id) from students")
    String findMaxId();




    //entity中实体的属性名和数据库列名不一致时的配置样例
//    @Select("select * from students")
//    @Results(value = {        //column是数据库中的列名，property是entity实体中的属性名
//            @Result(id = true, column = "", property = ""),   //主键加上id=true
//            @Result(column = "", property = ""),              //非主键不用假id=true
//            @Result(column = "", property = ""),
//            ...
//    })
//    List<Student> findAll2();
}
