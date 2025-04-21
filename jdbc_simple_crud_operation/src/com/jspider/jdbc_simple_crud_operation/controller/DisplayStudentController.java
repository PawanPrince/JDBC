package com.jspider.jdbc_simple_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayStudentController {

	public static void main(String[] args) {
		Connection connection=null;
		
		try {
			connection=JdbcConnection.getJdbcConnection();
			//step-3 create statement
			Statement statement=connection.createStatement();
			
			//step-4 execute Query
			ResultSet set=statement.executeQuery("SELECT * FROM student");
			
			while(set.next()) {
				
				int id=set.getInt("id");
				
				String name = set.getString("name");
				
				String email = set.getString("email");
				
				long phone = set.getLong("phone");
				
				System.out.println("id = "+id);
				System.out.println("name = "+name);
				System.out.println("email = "+email);
				System.out.println("phone = "+phone);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
	}
}
