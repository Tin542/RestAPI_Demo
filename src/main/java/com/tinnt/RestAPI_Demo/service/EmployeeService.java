package com.tinnt.RestAPI_Demo.service;

import java.util.List;

import com.tinnt.RestAPI_Demo.entity.Employee;

public interface EmployeeService {

	public List<Employee> retriveEmployee();
	
	public Employee getEmployee(long id);
	
	public Employee saveEmployee(Employee emp);
	
	public void deleteEmployee(long id);
	
	public void updateEmployee(Employee emp);
	
}
