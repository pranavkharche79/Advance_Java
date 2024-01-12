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
	static PreparedStatement selpro,inspro,delprod,getbyid,updatebyid;
	static {
		try {
			conn=DBUtil.getMyConnection();
			selpro=conn.prepareStatement("select * from products");
			inspro=conn.prepareStatement("insert into products(title,description,unitprice,categoryid,unitinstock) values(?,?,?,?,?)");
			delprod=conn.prepareStatement("delete from products where productid=?");
			getbyid=conn.prepareStatement("select * from products where productid=?");
			updatebyid=conn.prepareStatement("update products set title=?,description=?,unitprice=?,categoryid=?,unitinstock=? where productid=?");
		} catch (SQLException e) {
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

	@Override
	public void deleteprodbyid(int pid) {
		try {
			delprod.setInt(1, pid);
			delprod.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Product getproductbyid(int id) {
		try {
			getbyid.setInt(1, id);
			ResultSet rs=getbyid.executeQuery();
			if(rs.next()) {
				return new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void updateproduct(Product p) {
		try {
			updatebyid.setString(1,p.getTitle());
			updatebyid.setString(2,p.getDesc());
			updatebyid.setInt(3,p.getUnit());
			updatebyid.setInt(4,p.getCatid());
			updatebyid.setInt(5,p.getUnitstock());
			updatebyid.setInt(6,p.getPid());
			updatebyid.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
