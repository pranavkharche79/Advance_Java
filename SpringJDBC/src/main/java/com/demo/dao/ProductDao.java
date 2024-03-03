package com.demo.dao;

import java.util.List;

import com.demo.model.Product;

public interface ProductDao {

	int save(Product p);

	List<Product> getAll();

	int removeById(int pid);

	int updateById(int pid, int qty, double pr);

	Product getById(int pid);

//	List<Product> getbyqty(int qty);

}
