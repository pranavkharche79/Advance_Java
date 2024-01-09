package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	
	public static void  main(String[]args)
	{
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			
			String url="jdbc:mysql://localhost:3306/ecommerce?useSSL=false";
			
			Connection conn =DriverManager.getConnection(url ,"root","welcome");
			
			if(conn != null)
			{
				System.out.println("connection done");
			}
			
			
			
		} catch (SQLException e) {
			
			System.out.println("error occured"+ e.getMessage());
			e.printStackTrace();
		}
	}
}
