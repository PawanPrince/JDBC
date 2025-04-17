package com.jspider.jdbc_simple_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * Preapred Statement: It uses placeholder (?) to place the value at desicnated column with the help of setter method()
 * 
 * Setter Method() of prepared statement: setInt( int parameterIndex, Index x) 
 * 
 * ResultSet : getter method() column by column 
 */

public class jdbcConnection {
	
	public static Connection getJdbcConnection() {
		
		//Step-1 Load Or register driver  
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
//			Step -2  Create Connection
			
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-m13", "root", "root");
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
		
	}

}
