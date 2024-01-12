package com.demo.service;

import java.util.List;

import com.demo.beans.Employee;
import com.demo.dao.EmployeeDao;
import com.demo.dao.EmployeeDaoImpl;

public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeDao edao;
	
	public EmployeeServiceImpl() {
		edao = new EmployeeDaoImpl();
	}
	
	public void addNewEmployee(int id ,String nm,int salary,String gender) {
		edao.insertEmployee(id,nm,salary,gender);
	}

	@Override
	public boolean deleteById(int id) {
		return edao.deleteEmployee(id);
	}

	@Override
	public boolean modifyById(int id, String nm, int salary, String gender) {
		return edao.updateEmployee(id,nm,salary,gender);
	}

	@Override
	public List<Employee> displayAll() {
		return edao.getAllEmployees();
	}

	@Override
	public Employee getById(int id) {
		return edao.getEmpById(id);
	}

	@Override
	public List<Employee> displaySorted() {
		return edao.selSortedByPrice();
	}

	@Override
	public void closeMyconnection() {
		edao.closeMyConnection();
		
	}
}
