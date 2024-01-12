package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Employee;

public class EmployeeDaoImpl implements EmployeeDao{

	static Connection conn;
	static PreparedStatement insEmp,delEmp,upEmp,selEmp,selById,selSortBySalary;
	static {
		conn = DBUtil.getMyConnection();
		try {
			insEmp = conn.prepareStatement("insert into employee1 values(?,?,?,?)");
			delEmp = conn.prepareStatement("delete from employee1 where id = ?");
			upEmp = conn.prepareStatement("update employee1 set name = ?, salary=?, gender=? where id=?");
			selEmp = conn.prepareStatement("select * from employee1");
			selById = conn.prepareStatement("select * from employee1 where id=?");
			selSortBySalary = conn.prepareStatement("select * from employee1 order by salary desc");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void insertEmployee(int id, String nm, int salary, String gender) {
		try {
			insEmp.setInt(1, id);
			insEmp.setString(2, nm);
			insEmp.setInt(3, salary);
			insEmp.setString(4, gender);
			
			insEmp.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public boolean deleteEmployee(int id) {
		try {
			delEmp.setInt(1, id);
			
			int n = delEmp.executeUpdate();
			if(n > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean updateEmployee(int id, String nm, int salary, String gender) {
		try {
			upEmp.setString(1, nm);
			upEmp.setInt(2, salary);
			upEmp.setString(3, gender);
			upEmp.setInt(4, id);
			
			int n = upEmp.executeUpdate();
			if(n>0) {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> elist = new ArrayList<>();
		try {
			ResultSet rs = selEmp.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String nm = rs.getString(2);
				int salary = rs.getInt(3);
				String gender = rs.getString(4);
				
				Employee e = new Employee(id,nm,salary,gender);
				elist.add(e);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return elist;
		
	}
	@Override
	public Employee getEmpById(int id) {
		try {
			selById.setInt(1, id);
			ResultSet rs = selById.executeQuery();
			if(rs.next()) {
				return new Employee(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Employee> selSortedByPrice() {
		List<Employee> elist = new ArrayList<>();
		try {
			ResultSet rs = selSortBySalary.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String nm = rs.getString(2);
				int salary = rs.getInt(3);
				String gender = rs.getString(4);
				
				Employee e = new Employee(id,nm,salary,gender);
				elist.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return elist; 
	}
	@Override
	public void closeMyConnection() {
		DBUtil.closeMyConnection();
		
	}

}
