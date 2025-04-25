package com.jspider.prepared_statement_crud_operation.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class ProductConnection {

	public static Connection getProductConnection() {
		System.out.println("getProductConnection method execution started");
		try {
			//step-1 Register Driver
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			
			//step-2 create connection
			System.out.println("getProductConnection method execution ended");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-m13", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("getProductConnection method execution ended");
			return null;
		}
	}
}
