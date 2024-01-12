package test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Department;
import model.Employee;

public class TestOneToMany {

	public static void main(String[] args) 
	{
		Employee e1=new Employee(12,"xxx",3456);
		Employee e2=new Employee(13,"yyyy",5555);
		Employee e3=new Employee(14,"zzzzz",5656);
		Employee e4=new Employee(15,"pppp",4444);
		Set<Employee> eset1=new HashSet<>();
		eset1.add(e1);
		eset1.add(e2);
		Set<Employee> eset2=new HashSet<>();
		eset2.add(e3);
		eset2.add(e4);
		Department d1=new Department(10,"Hr","Pune",eset1);
		Department d2=new Department(11,"Purchase","Mumbai",eset2);
		e1.setDept(d1);
		e2.setDept(d1);
		e3.setDept(d2);
		e4.setDept(d2);
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s1=sf.openSession();
		Transaction t1=s1.beginTransaction();
		s1.save(d1);
		s1.save(d2);
		s1.save(e1);
		s1.save(e2);
		s1.save(e3);
		s1.save(e4);
		t1.commit();
		
		// For Retrieve Data
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		System.out.println("Query for searching department object \n");
		Department d11=session.get(Department.class, 10);
		System.out.println("\n Query for searching employee object using join \n");
		Employee e11=session.get(Employee.class,14 );
		System.out.println("\n only department object \n");
		System.out.println(d11);
		System.out.println("\n getting employss set by department object \n");
		System.out.println(d11.geteSet());
		System.out.println("\n Only a employee full details by join \n");
		System.out.println(e11);
		tr.commit();
		
	}
}
