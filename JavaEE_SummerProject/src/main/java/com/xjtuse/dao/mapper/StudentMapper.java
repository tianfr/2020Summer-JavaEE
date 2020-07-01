package com.xjtuse.dao.mapper;

import java.util.List;

import com.xjtuse.entity.Student;
import org.apache.ibatis.annotations.Param;


public interface StudentMapper {
	
	/**
	 * 根据学生id查询学生信息
	 * @param id 学生ID
	 * @return com.hwadee.hello.entity.Student
	 */
//	Student findById(int id);
	
//	List<Student> findAll();
//
//	List<Student> search(@Param("id") int id, @Param("age") int age);
	
	int insert(Student stu);
//
//	int delete(int id);
//
//	int update(Student stu);
}
