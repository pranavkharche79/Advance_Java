package com.demo.dao;

import java.util.List;

import com.demo.model.Product;

public interface ProductDao {

	List<Product> getallproducts();

	void insertproduct(Product p);

}
