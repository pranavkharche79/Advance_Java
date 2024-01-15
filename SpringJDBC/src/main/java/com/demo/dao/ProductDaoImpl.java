package com.demo.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private JdbcTemplate jt;

	@Override
	public int save(Product p) {
		return jt.update("insert into product values(?,?,?,?)",new Object[]{p.getPid(),p.getPname(),p.getQty(),p.getPrice()});
	}

	@Override
	public List<Product> getAll() {
		List<Product> plist = jt.query("select * from product", 
				(rs,num)->{
					Product p = new Product();
					p.setPid(rs.getInt(1));
					p.setPname(rs.getString(2));
					p.setQty(rs.getInt(3));
					p.setPrice(rs.getDouble(4));
					return p;
				});
		return plist;
	}

	@Override
	public int removeById(int pid) {
		return jt.update("delete from product where pid=?",new Object[] {pid});
	}

	@Override
	public int updateById(int pid, int qty, double pr) {
		return jt.update("update product set qty=?,price=? where pid = ?",new Object[] {qty,pr,pid});
	}

	@Override
	public Product getById(int pid) {
		Product plist = jt.queryForObject("select * from product where pid=?", new Object[] {pid},
				(rs,num)->{
					Product p =new Product();
					p.setPid(rs.getInt(1));
					p.setPname(rs.getString(2));
					p.setQty(rs.getInt(3));
					p.setPrice(rs.getDouble(4));
					return p;
				});
		return plist;
		
	}

//	@Override
//	public List<Product> getbyqty(int qty) {
//		List<Product> lis = jt.query("select * from product where pid=?", new Object[] {qty},
//				(rs,num)->{
//					Product p =new Product();
//					p.setPid(rs.getInt(1));
//					p.setPname(rs.getString(2));
//					p.setQty(rs.getInt(3));
//					p.setPrice(rs.getDouble(4));
//					return p;
//				});
//		return lis;
//	}
	
	

}
