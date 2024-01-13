package test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Employee;
import model.Project;

public class TestManyToMany {

	public static void main(String[] args) {
		Employee e1=new Employee(1,"xxxx");
		Employee e2=new Employee(2,"yyyy");
		Employee e3=new Employee(3,"zzzz");
		Employee e4=new Employee(4,"pppp");
		Set<Employee> eset1=new HashSet<Employee>();
		eset1.add(e1);
		eset1.add(e4);
		eset1.add(e3);
		Set<Employee> eset2=new HashSet<Employee>();
		eset2.add(e1);
		eset2.add(e2);
		eset2.add(e3);
		Project p1=new Project(10,"banking");
		Project p2=new Project(11,"Loan");
		p1.setEset(eset1);
		p2.setEset(eset2);
		Set<Project> pset1=new HashSet<>();
		pset1.add(p1);
		pset1.add(p2);
		Set<Project> pset2=new HashSet<>();
		pset2.add(p1);
		Set<Project> pset3=new HashSet<>();
		pset3.add(p2);
		e1.setPset(pset1);
		e2.setPset(pset2);
		e3.setPset(pset1);
		e4.setPset(pset3);	
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session ses=sf.openSession();
		Transaction tr=ses.beginTransaction();
		ses.save(p1);
		ses.save(p2);
		ses.save(e1);
		ses.save(e2);
		ses.save(e3);
		ses.save(e4);
		tr.commit();
	
	}

}
