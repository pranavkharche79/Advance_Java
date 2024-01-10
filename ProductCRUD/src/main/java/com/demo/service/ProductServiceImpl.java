package com.demo.service;

import java.util.List;

import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;
import com.demo.model.Product;

public class ProductServiceImpl implements ProductService
{
	static ProductDao pdao;
	static {
		pdao=new ProductDaoImpl();
	}
	@Override
	public List<Product> getallproducts() {
		return pdao.getallproducts();
	}
	@Override
	public void insertproduct(Product p) {
		pdao.insertproduct(p);
	}
	@Override
	public void deleteprodbyid(int pid) {
		pdao.deleteprodbyid(pid);
		
	}

}
