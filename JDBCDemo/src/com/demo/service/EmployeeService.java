package com.demo.service;

import java.util.List;

import com.demo.beans.Employee;

public interface EmployeeService {
	public void addNewEmployee(int id ,String nm,int salary,String gender);

	public boolean deleteById(int id);

	public boolean modifyById(int id, String nm, int salary, String gender);

	public List<Employee> displayAll();

	public Employee getById(int id);

	public List<Employee> displaySorted();

	public void closeMyconnection();
}
