package com.hwadee.hello.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.RowProcessor;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.hwadee.hello.entity.Student;
import com.hwadee.hello.utils.JDBCDataSource;

public class StudentDao2 {

	private QueryRunner qr = new QueryRunner(JDBCDataSource.getDataSource());

	public long insert(Student stu) {
		String sql = "INSERT INTO student" + "(stu_name,stu_sex,stu_age,stu_pro) " + "VALUES(?,?,?,?)";

		try {
			return qr.insert(sql, new ScalarHandler<Long>(1), stu.getStuName(), stu.getStuSex(), stu.getStuAge(),
					stu.getStuPro());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public int delete(int id) {
		String sql = "DELETE FROM student WHERE STU_ID = ?";
		try {
			return qr.update(sql, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int update(Student stu) {
		String sql = "UPDATE student SET " + "stu_name=?, stu_sex=?,stu_age = ?,stu_pro = ? " + " WHERE STU_ID = ?";
		try {
			return qr.update(sql, stu.getStuName(), stu.getStuSex(), stu.getStuAge(), stu.getStuPro(), stu.getStuId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public Student findById(int id) {
		String sql = "SELECT "
				+ "stu_name stuName,stu_sex stuSex,stu_age stuAge,stu_pro stuPro,stu_id stuId " 
				+ "FROM student " 
				+ "WHERE stu_id = ?";

		try {
			return qr.query(sql, new BeanHandler<Student>(Student.class), id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Student> findAll() {
		//stuName
		String sql = "SELECT "
				+ " stu_name,stu_sex,stu_age,stu_pro,stu_id "
				+ "FROM student ";
		try {
			//开启下划线->驼峰转换所用
			BeanProcessor bean = new GenerousBeanProcessor();
			RowProcessor processor = new BasicRowProcessor(bean);

			return qr.query(sql, new BeanListHandler<Student>(Student.class, processor));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Student> findByKey(String key) {
		//stuName
		String sql = "SELECT "
				+ " stu_name,stu_sex,stu_age,stu_pro,stu_id "
				+ "FROM student "
				+ "WHERE stu_name LIKE '%"+ key +"%'";
		try {
			//开启下划线->驼峰转换所用
			BeanProcessor bean = new GenerousBeanProcessor();
			RowProcessor processor = new BasicRowProcessor(bean);

			return qr.query(sql, new BeanListHandler<Student>(Student.class, processor));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
