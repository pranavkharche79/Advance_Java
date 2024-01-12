package com.demo.dao;

import java.util.List;

import com.demo.model.Product;

public interface ProductDao {

	List<Product> getallproducts();

	void insertproduct(Product p);

	void deleteprodbyid(int pid);

	Product getproductbyid(int id);

	void updateproduct(Product p);

}
