package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {

	public static void main(String[] args) {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url = "jdbc:mysql://localhost:3306/ecommerce?useSSL=false";
			Connection conn = DriverManager.getConnection(url,"root","welcome");
			
			if(conn != null) {
				System.out.println("Connected");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error message" + e.getMessage());
			e.printStackTrace();
		}

	}

}
