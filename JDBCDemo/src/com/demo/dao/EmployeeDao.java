package com.demo.dao;

import java.util.List;

import com.demo.beans.Employee;

public interface EmployeeDao {

	void insertEmployee(int id, String nm, int salary, String gender);

	boolean deleteEmployee(int id);

	boolean updateEmployee(int id, String nm, int salary, String gender);

	List<Employee> getAllEmployees();

	Employee getEmpById(int id);

	List<Employee> selSortedByPrice();

	void closeMyConnection();
	
	

}
