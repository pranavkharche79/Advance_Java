package com.demo.test;

import java.util.List;
import java.util.Scanner;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.demo.model.Employee;



public class TestEmployee {

	public static void main(String[] args) {
		//it is in transient state
				SessionFactory sf=new Configuration().configure().buildSessionFactory();
				Session s1=sf.openSession();
				Transaction tr=s1.beginTransaction();	
				
				Scanner sc=new Scanner(System.in);
				int a=0;
				do {
				System.out.println("\n1: Add Employee\n2: Display All\n3: Find by id\n4: Delete by id\n5: Update by id \n6: Exit");
				System.out.println("Enter Choice: ");
				a=sc.nextInt();
					switch (a) 
					{
					case 1:
						
						
						sc.nextLine();
						System.out.println("Enter name: ");
						String nm=sc.nextLine();
						System.out.println("Enter salary: ");
						Double sal=sc.nextDouble();
						Employee e1=new Employee(nm,sal);
						s1.save(e1);
						tr.commit();
						
						break;
					case 2:
						Query query = s1.createQuery("From Employee");
						List<Employee> lst = query.list();
						System.out.println(lst);
						break;
					case 3:
						System.out.println("Enter id: ");
						 int id=sc.nextInt();
						Employee emp1=s1.get(Employee.class, id);
						tr.commit();
						System.out.println(emp1);
						break;
					case 4:
						System.out.println("Enter id: ");
						id=sc.nextInt();
						emp1=s1.get(Employee.class, id);
						s1.delete(emp1);
						System.out.println("Deleted obj="+emp1);
						tr.commit();
						break;
					case 5:
						System.out.println("Enter id: ");
						id=sc.nextInt();
						emp1=s1.get(Employee.class, id);
						sc.nextLine();
						System.out.println("Updated name= ");
						nm=sc.nextLine();
						System.out.println("Updated sal= ");
						sal=sc.nextDouble();
						emp1.setEname(nm);
						emp1.setSal(sal);
						tr.commit();
						break;
					case 6:
						System.out.println("Thanks for visiting....");
						s1.close();
						break;
					}
				} while (a!=6);
				

	}

}
