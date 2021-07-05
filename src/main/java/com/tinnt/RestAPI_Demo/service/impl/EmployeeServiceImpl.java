package com.tinnt.RestAPI_Demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tinnt.RestAPI_Demo.entity.Employee;
import com.tinnt.RestAPI_Demo.repository.EmployeeRepository;
import com.tinnt.RestAPI_Demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepository;

	public EmployeeRepository getEmpRepository() {
		return empRepository;
	}

	public void setEmpRepository(EmployeeRepository empRepository) {
		this.empRepository = empRepository;
	}

	@Override
	public List<Employee> retriveEmployee() {
		List<Employee> listEmp = empRepository.findAll();
		return listEmp;
	}

	@Override
	public Employee getEmployee(long id) {
		Employee emp = empRepository.findById(id).get();
		return emp;
	}

	@Override
	public Employee saveEmployee(Employee emp) {
		Employee empEntity = empRepository.save(new Employee(emp.getId(), emp.getName(), emp.getEmail(), emp.getRole()));
		return empRepository.save(empEntity);
	}

	@Override
	public void deleteEmployee(long id) {
		empRepository.deleteById(id);	
	}

	@Override
	public void updateEmployee(Employee emp) {
		empRepository.save(emp);	
	}


	
	
	
}
