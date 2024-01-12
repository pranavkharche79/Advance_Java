package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.model.Address;
import com.demo.model.MyUser;

public class TestMyUser {

	public static void main(String[] args) {
		
		Address a1=new Address(1,"baner","pune");
		Address a2=new Address(2,"Deccan","pune");
		MyUser u1=new MyUser(10,"xxxx",a1);
		MyUser u2=new MyUser(11,"yyyy",a2);
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s1=sf.openSession();
		Transaction t1=s1.beginTransaction();
		s1.save(u1);
		s1.save(u2);
		t1.commit();
		
		Session s2=sf.openSession();
		Transaction t2=s2.beginTransaction();
		MyUser emp1=s2.get(MyUser.class, 10);
		t2.commit();
		System.out.println(emp1);
	}

}
