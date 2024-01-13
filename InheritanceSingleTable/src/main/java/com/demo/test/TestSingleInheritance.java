package com.demo.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.model.NonPerishableProduct;
import com.demo.model.PerishableProduct;



public class TestSingleInheritance {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session ses= sf.openSession();
		Transaction tr=ses.beginTransaction();
		PerishableProduct p=new PerishableProduct();
		PerishableProduct p1=new PerishableProduct(12,"Biscuits", new Date(), new Date());
		NonPerishableProduct p2=new NonPerishableProduct(13,"Chair",new Date(),"Furniture");
		ses.save(p2);
		ses.save(p1);
		tr.commit();
	}

}
