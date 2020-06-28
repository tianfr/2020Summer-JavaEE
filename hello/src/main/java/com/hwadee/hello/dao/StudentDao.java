package com.hwadee.hello.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hwadee.hello.entity.Student;

public class StudentDao {
	
	private static final String USER = "root";
	private static final String PASSWORD = "123456";
	private static final String URL 
		= "jdbc:mysql://127.0.0.1:3306/test";
	private static final String DRIVER_CLASS 
		= "com.mysql.jdbc.Driver";
	
	
	public int insert(Student stu) {
		Connection conn = null;
		int result = -1;
		try {
			//加载驱动
			Class.forName(DRIVER_CLASS);
			//获取连接
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "INSERT INTO student"
					+ "(stu_name,stu_sex,stu_age,stu_pro) "
					+ "VALUES(?,?,?,?)";
			//Statement
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, stu.getStuName());
			ps.setString(2, stu.getStuSex());
			ps.setInt(3, stu.getStuAge());
			ps.setString(4, stu.getStuPro());
			//执行SQL
			result = ps.executeUpdate();
			//获取自增长主键
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) {
				stu.setStuId( rs.getInt(1) );
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//关闭连接
				if( null != conn && ! conn.isClosed() )
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	public int delete(int id) {
		Connection conn = null;
		int result = -1;
		try {
			//加载驱动
			Class.forName(DRIVER_CLASS);
			//获取连接
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "DELETE FROM STUDENT WHERE STU_ID = ?";
			//Statement
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			//执行SQL
			result = ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//关闭连接
				if( null != conn && ! conn.isClosed() )
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int update(Student stu) {
		Connection conn = null;
		int result = -1;
		try {
			//加载驱动
			Class.forName(DRIVER_CLASS);
			//获取连接
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "UPDATE student SET "
					+ "stu_name=?, stu_sex=?,stu_age = ?,stu_pro = ? "
					+ " WHERE STU_ID = ?";
			//Statement
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, stu.getStuName());
			ps.setString(2, stu.getStuSex());
			ps.setInt(3, stu.getStuAge());
			ps.setString(4, stu.getStuPro());
			ps.setInt(5, stu.getStuId());
			//执行SQL
			result = ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//关闭连接
				if( null != conn && ! conn.isClosed() )
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public Student findById(int id) {
		Connection conn = null;
		try {
			//加载驱动
			Class.forName(DRIVER_CLASS);
			//获取连接
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "SELECT "
						+ " stu_name,stu_sex,stu_age,stu_pro,stu_id "
						+ "FROM STUDENT "
						+ "WHERE stu_id = ?";
			//Statement
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			//执行SQL
			ResultSet rs = ps.executeQuery();
			if( rs.next() ) {
				Student stu = new Student();
				stu.setStuName(rs.getString(1));
				stu.setStuSex(rs.getString(2));
				stu.setStuAge(rs.getInt(3));
				stu.setStuPro(rs.getString("stu_pro"));
				stu.setStuId(rs.getInt("stu_id"));
				return stu;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//关闭连接
				if( null != conn && ! conn.isClosed() )
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public List<Student> findAll() {
		Connection conn = null;
		List<Student> students = new ArrayList<Student>();
		try {
			//加载驱动
			Class.forName(DRIVER_CLASS);
			//获取连接
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "SELECT "
						+ " stu_name,stu_sex,stu_age,stu_pro,stu_id "
						+ "FROM STUDENT ";
			//Statement
			PreparedStatement ps = conn.prepareStatement(sql);

			//执行SQL
			ResultSet rs = ps.executeQuery();
			while( rs.next() ) {
				Student stu = new Student();
				stu.setStuName(rs.getString(1));
				stu.setStuSex(rs.getString(2));
				stu.setStuAge(rs.getInt(3));
				stu.setStuPro(rs.getString("stu_pro"));
				stu.setStuId(rs.getInt("stu_id"));
				students.add(stu);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//关闭连接
				if( null != conn && ! conn.isClosed() )
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return students;
	}

}
