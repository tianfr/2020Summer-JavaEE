package com.xjtuse.summerproject.mapper;

import com.xjtuse.summerproject.entity.Student;

import java.util.List;

//用户的持久层接口
public interface StudentMapper {

    //查询所有
    List<Student> findAll();

    //插入
    void insertStudent(Student student);

    //修改
    void updateStudent(Student student);

    //删除
    void deleteStudent(String stuId);

    //根据id查询学生
    Student findById(String stuId);

    //根据名称模糊查询学生
    List<Student> findByName(String name);

    //查询学生总数
    Integer findTotal();
}
