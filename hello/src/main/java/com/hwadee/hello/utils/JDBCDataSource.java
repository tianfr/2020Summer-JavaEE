package com.hwadee.hello.utils;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class JDBCDataSource {
	
	private static ComboPooledDataSource dataSource;
	
	static {
		try {
			dataSource = new ComboPooledDataSource();
			dataSource.setJdbcUrl("jdbc:mysql://47.94.249.153:3306/test");
			dataSource.setUser("javaee");
			dataSource.setPassword("javaee");
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}
	
	public static DataSource getDataSource() {
		return dataSource;
	}
}
