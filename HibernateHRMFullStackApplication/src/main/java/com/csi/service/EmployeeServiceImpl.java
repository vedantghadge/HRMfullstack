package com.csi.service;

import java.util.List;

import com.csi.dao.EmployeeDao;
import com.csi.dao.EmployeeDaoImpl;
import com.csi.model.Employee;

public class EmployeeServiceImpl implements EmployeeService{

	EmployeeDao employeedaoImpl=new EmployeeDaoImpl();
	
	
	@Override
	public void signUp(Employee employee) {
		// TODO Auto-generated method stub
		employeedaoImpl.signUp(employee);
		
	}

	@Override
	public boolean signIn(String empEmailId, String empPassword) {
		
		return employeedaoImpl.signIn(empEmailId, empPassword);
	}

	@Override
	public Employee getDataById(int empId) {
		// TODO Auto-generated method stub
		return employeedaoImpl.getDataById(empId);
	}

	@Override
	public List<Employee> getAllData() {
		// TODO Auto-generated method stub
		return employeedaoImpl.getAllData();
	}

	@Override
	public void updateData(int empID, Employee employee) {
		// TODO Auto-generated method stub
		
		employeedaoImpl.updateData(empID, employee);
		
	}

	@Override
	public void deleteDataById(int empId) {
		// TODO Auto-generated method stub
		employeedaoImpl.deleteDataById(empId);
	}

	@Override
	public void deleteAllData() {
		// TODO Auto-generated method stub
		employeedaoImpl.deleteAllData();
		
	}

}
