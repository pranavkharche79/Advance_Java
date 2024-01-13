package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



import model.Employee;
import model.Project;

public class TestRetriveData {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Employee e=session.get(Employee.class, 1);
		Project p=session.get(Project.class, 10);
		System.out.println(p+" "+p.getEset());
		tr.commit();

	}

}