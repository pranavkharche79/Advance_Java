package com.demo.service;

import java.util.List;

import com.demo.model.Product;

public interface ProductService {

	List<Product> getallproducts();

	void insertproduct(Product p);

	void deleteprodbyid(int pid);

}
