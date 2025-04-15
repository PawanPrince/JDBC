package com.jspider.jdbc_simple_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * @since 15-04-25
 * @author Pawan Jha
 */
public class StudentInsertController {
	
	public static void main(String[] args) {
		Connection connection=null;
		    // Step-1  Load/Register Driver
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
	     	// Step -2 Create Connection
			
			String url  = "jdbc:mysql://localhost:3306/jdbc-m13";
			String user = "root";
			String pass = "root";
			
	   connection=DriverManager.getConnection(url, user, pass);
		
		System.out.println(connection);
		
			// Step-3 Create Statement
		
		Statement statement=connection.createStatement();
		
		    //Step-4  Execute SQL Query
		
		String insertStudentQuery = "insert into student(id,name,email,phone) values(125,'Prince','prince@gmail.com',9973332818)";
		int a =statement.executeUpdate(insertStudentQuery);
		System.out.println(a);
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			
			// Step-5   Close Connection
			
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}

}
