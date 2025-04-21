package com.jspider.jdbc_simple_crud_operation.controller;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StudentInsertController {
 
	public static void main(String[] args) {
		Connection connection=null;
		try {
			connection=JdbcConnection.getJdbcConnection();
			
			System.out.println(connection);
			
			//step-3 create statement 
			Statement statement=connection.createStatement();
			
			//step-4 Execute SQL Query
			String insertStudentQuery = "insert into student(id,name,email,phone) values(876786,'ninja','ninja@gmail.com',9090909090)";
			
			int a=statement.executeUpdate(insertStudentQuery);
			
			System.out.println(a);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//step-5 close connection
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
