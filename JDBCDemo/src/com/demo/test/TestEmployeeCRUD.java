package com.demo.test;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Employee;
import com.demo.service.EmployeeService;
import com.demo.service.EmployeeServiceImpl;

public class TestEmployeeCRUD {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		EmployeeService eservice=new EmployeeServiceImpl();
		int choice=0;
		do {
		System.out.println("1. add Employee\n2. Delete Employee\n3. modify Employee");
		System.out.println("4. display all\n5. display by id\n6. display in sorted order of salary\n7. exit");
		System.out.println("Choice : ");
		choice=sc.nextInt();
		switch(choice) {
		case 1:
			System.out.println("Enter the id");
			int id = sc.nextInt();
			System.out.println("Enter name:");
			String nm = sc.next();
			System.out.println("Enter salary");
			int salary = sc.nextInt();
			System.out.println("Enter gender");
			String gender = sc.next();
			eservice.addNewEmployee(id,nm,salary,gender);
			break;
		case 2:
			System.out.println("enter id");
			id=sc.nextInt();
			boolean status=eservice.deleteById(id);
			if(status) {
				System.out.println("deleted successfully");
			}
			else {
				System.out.println("not found");
			}
			break;
		case 3:
			System.out.println("enter id");
			id=sc.nextInt();
			System.out.println("enter name");
			nm=sc.next();
			System.out.println("enter salary");
			salary=sc.nextInt();
			System.out.println("enter gender");
			gender=sc.next();
			status=eservice.modifyById(id,nm,salary,gender);
			if(status) {
				System.out.println("modified successfully");
			}
			else {
				System.out.println("not found");
			}
			break;
		case 4:
			List<Employee> elist=eservice.displayAll();
			elist.forEach(System.out::println);
			break;
		case 5:
			System.out.println("enter id");
			id=sc.nextInt();
			Employee e=eservice.getById(id);
			if(e!=null) {
				System.out.println(e);
			}
			else {
				System.out.println("not found");
			}
			break;
		case 6:
			elist=eservice.displaySorted();
			elist.forEach(System.out::println);
			break;
		case 7:
			eservice.closeMyconnection();
			sc.close();
			System.out.println("Thank you for visiting....");
			break;
		default:
			break;
			
		}
		}while(choice!=7);
		

	}

}
