package com.jspider.jdbc_simple_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateStudentController {

	public static void main(String[] args) {
		Connection connection = null;

		try {
			connection=JdbcConnection.getJdbcConnection();
			// step-3 create statement
			Statement statement = connection.createStatement();
			
			
			//execute query
			String updateStudentNameQuery = "update student set name='rohit' where id=123";
			
			int a=statement.executeUpdate(updateStudentNameQuery);
			
			String msg = a!=0?"updated":"given id not found or check your code";
			
			System.out.println(msg);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
