package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.model.Product;


public class ProductDaoImpl implements ProductDao 
{
	static Connection conn;
	static PreparedStatement selpro,inspro;
	static {
		try {
			conn=DBUtil.getMyConnection();
			selpro=conn.prepareStatement("select * from products");
			inspro=conn.prepareStatement("insert into products(title,description,unitprice,categoryid,unitinstock) values(?,?,?,?,?)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Product> getallproducts() {
		List<Product> lst= new ArrayList<Product>();
		try {
			ResultSet rs= selpro.executeQuery();
			while (rs.next()){
				Product p=new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6));
				lst.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
	}

	@Override
	public void insertproduct(Product p) {
		try {
			inspro.setString(1, p.getTitle());
			inspro.setString(2, p.getDesc());
			inspro.setInt(3, p.getUnit());
			inspro.setInt(4, p.getCatid());
			inspro.setInt(5, p.getUnitstock());
			inspro.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
