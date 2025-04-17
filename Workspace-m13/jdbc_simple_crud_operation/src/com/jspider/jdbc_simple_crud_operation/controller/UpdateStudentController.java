package com.jspider.jdbc_simple_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateStudentController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection=null;
		try {
			
			connection =jdbcConnection.getJdbcConnection();
			
//			//step-1 load/register driver
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			
//			
//			//step-2 create connection(I)
//			String url="jdbc:mysql://localhost:3306/jdbc-m13";
//			String user="root";
//			String pass="root";
//			
//			
//			connection=DriverManager.getConnection(url, user, pass);
//		System.out.println(connection);
//			
			
			//step-3 create statement(I): statement
			Statement statement=connection.createStatement();
			
			//step-4 Execute SQl Query
			String updateStudentNameQuery="update student set name='Pawan' where id=102";
			
			int a=statement.executeUpdate(updateStudentNameQuery);
			
			String msg=a!=0?"updated":"given id not found or check your code";
			
			System.out.println(msg);
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}

	}

}