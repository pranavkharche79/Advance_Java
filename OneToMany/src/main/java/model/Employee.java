package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee11")
public class Employee {

	@Id
	private int emid;
	private String ename;
	private double sal;
	@OneToOne
	@JoinColumn(name="deptno")
	private Department dept;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int emid, String ename, double sal, Department dept) {
		super();
		this.emid = emid;
		this.ename = ename;
		this.sal = sal;
		this.dept = dept;
	}
	
	public Employee(int emid, String ename, double sal) {
		super();
		this.emid = emid;
		this.ename = ename;
		this.sal = sal;
	}
	public int getEmid() {
		return emid;
	}
	public void setEmid(int emid) {
		this.emid = emid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Employee [emid=" + emid + ", ename=" + ename + ", sal=" + sal + ", dept=" + dept + "]";
	}
	
}
