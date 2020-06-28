package com.hwadee.hello.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.hwadee.hello.entity.Student;

public class StudentDao2Test {
	
	private StudentDao2 dao = new StudentDao2();

	@Test
	public void testInsert() {
		Student stu = new Student();
		stu.setStuName("王五3");
		stu.setStuSex("男");
		stu.setStuAge(18);
		stu.setStuPro("计科");
		
		long id = dao.insert(stu);
		System.out.println("id=" + id);
	}
	@Test
	public void testDelete() {
		int rows = dao.delete(5);
		Assert.assertEquals(1, rows);
	}
	@Test
	public void testUpdate() {
		Student stu = new Student();
		stu.setStuName("马六");
		stu.setStuSex("女");
		stu.setStuAge(19);
		stu.setStuPro("软件");
		stu.setStuId(6);
		
		int rows = dao.update(stu);
		Assert.assertEquals(1, rows);
	}
	@Test
	public void testFindById() {
		Student stu = dao.findById( 7 );
		System.out.println( stu );
		Assert.assertNotNull(stu);
	}
	@Test
	public void testFindAll() {
		List<Student> list = dao.findAll();
		System.out.println(list);
		Assert.assertFalse(list.isEmpty());
	}


}
