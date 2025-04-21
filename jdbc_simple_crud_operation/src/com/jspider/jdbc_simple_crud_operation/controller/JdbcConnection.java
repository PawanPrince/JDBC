package com.jspider.jdbc_simple_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;



public class JdbcConnection {

	public static Connection getJdbcConnection() {
		
		
		try {
			//step-1 load/register driver class
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			
			//step-2 create connection
			Connection connection=
			DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-m13", "root", "root");
		
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
