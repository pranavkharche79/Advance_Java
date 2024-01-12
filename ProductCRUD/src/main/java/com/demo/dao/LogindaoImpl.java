package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.model.MyUser;

public class LogindaoImpl implements Logindao 
{
	static Connection conn;
	static PreparedStatement seluser;
	static {
		conn=DBUtil.getMyConnection();
		try {
			seluser=conn.prepareStatement("select username,password,role from login where username=? and password=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public MyUser validate(String uname, String pass) {
		try {
			seluser.setString(1, uname);
			seluser.setString(2, pass);
			ResultSet rs=seluser.executeQuery();
			if(rs.next())
			{
				return new MyUser(rs.getString(1),rs.getString(2),rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
