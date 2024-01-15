package com.demo.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.ProductDao;
import com.demo.model.Product;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductDao pdao;

	@Override
	public int addnewProduct() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enetr pid");
		int pid=sc.nextInt();
		System.out.println("enetr pname");
		String pname=sc.next();
		System.out.println("enetr qty");
		int qty=sc.nextInt();
		System.out.println("enetr price");
		double price=sc.nextDouble();
		Product p=new Product(pid,pname,qty,price);
		return pdao.save(p);
	}

	@Override
	public List<Product> getAll() {
		return pdao.getAll();
	}

	@Override
	public int deleteById(int pid) {
		return pdao.removeById(pid);
	}

	@Override
	public int modifyById(int pid, int qty, double pr) {
		return pdao.updateById(pid,qty,pr);
	}

	@Override
	public Product getById(int pid) {
		return pdao.getById(pid);
	}

//	@Override
//	public List<Product> getByQty(int qty) {
//		return pdao.getbyqty(qty);
//	}
	
	
}
