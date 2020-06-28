package com.hwadee.hello.mapper;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hwadee.hello.entity.Student;

public class StudentMapperTest {
	
	private static SqlSessionFactory sqlSessionFactory;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/*
	 * @Test public void testFindById() { SqlSession session =
	 * sqlSessionFactory.openSession();
	 * 
	 * try { Student stu = session .selectOne( "com.hwadee.hello.mapper" +
	 * ".StudentMapper.findById", 5); System.out.println( stu );
	 * Assert.assertNotNull(stu); } finally { session.close(); } }
	 */
	
//	@Test
//	public void testFindById() {
//		SqlSession session = sqlSessionFactory.openSession();
//		
//		try {
//			StudentMapper mapper = 
//				session.getMapper(StudentMapper.class);
//			Student stu = mapper.findById(16);
//			System.out.println( stu );
//			Assert.assertNotNull(stu);
//		} finally {
//			session.close();
//		}
//	}
//	
//	@Test
//	public void testFindAll() {
//		SqlSession session = sqlSessionFactory.openSession();
//		
//		try {
//			StudentMapper mapper = 
//				session.getMapper(StudentMapper.class);
//			List<Student> stu = mapper.findAll();
//			System.out.println( stu );
//			Assert.assertNotNull(stu);
//		} finally {
//			session.close();
//		}
//	}
//
//	@Test
//	public void testSearch() {
//		SqlSession session = sqlSessionFactory.openSession();
//		
//		try {
//			StudentMapper mapper = 
//				session.getMapper(StudentMapper.class);
//			List<Student> stu = mapper.search(10, 30);
//			System.out.println( stu );
//			Assert.assertNotNull(stu);
//		} finally {
//			session.close();
//		}
//	}
//	
//	@Test
//	public void testInsert() {
//		SqlSession session = sqlSessionFactory.openSession();
//		
//		try {
//			StudentMapper mapper = 
//				session.getMapper(StudentMapper.class);
//			Student stu = new Student();
//			stu.setStuName("张三");
//			stu.setStuAge(18);
//			stu.setStuSex("男");
//			stu.setStuPro("英语");
//			int rows = mapper.insert(stu);
//			session.commit();
//			System.out.println( "stuId = " + stu.getStuId());
//			Assert.assertEquals(1, rows);
//		} finally {
//			session.close();
//		}
//	}
//	@Test
//	public void testDelete() {
//		SqlSession session = sqlSessionFactory.openSession();
//		
//		try {
//			StudentMapper mapper = 
//				session.getMapper(StudentMapper.class);
//			int rows = mapper.delete(17);
//			session.commit();
//			Assert.assertEquals(1, rows);
//		} finally {
//			session.close();
//		}
//	}
//	
//	@Test
//	public void testUpdate() {
//		SqlSession session = sqlSessionFactory.openSession();
//		
//		try {
//			StudentMapper mapper = 
//				session.getMapper(StudentMapper.class);
//			Student stu = new Student();
//			stu.setStuId(17);
//			stu.setStuName("哈哈哈");
//			stu.setStuAge(20);
//			stu.setStuSex("女");
//			stu.setStuPro("英语");
//			int rows = mapper.update(stu);
//			session.commit();
//			System.out.println( stu);
//			Assert.assertEquals(1, rows);
//		} finally {
//			session.close();
//		}
//	}
}
