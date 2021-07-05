package com.tinnt.RestAPI_Demo.restcontroller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tinnt.RestAPI_Demo.entity.Employee;
import com.tinnt.RestAPI_Demo.exception.EmployeeException;
import com.tinnt.RestAPI_Demo.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	@Autowired 
	private EmployeeService empService;
	
	@GetMapping
	public List<Employee> getAllEmployee(){
		List<Employee> emps = empService.retriveEmployee();
		return emps;
	}
	
	@GetMapping("/{employeeId}")
	public Employee findEmployee(@PathVariable long employeeId) {
		Employee emp = empService.getEmployee(employeeId);
		if(emp == null) {
			throw new EmployeeException(employeeId);
		}
		return empService.getEmployee(employeeId);
	}
	
	@PostMapping
	public Employee saveEmployee(@RequestBody Employee emp) {
		return empService.saveEmployee(emp);
	}
	
	@DeleteMapping("/{employeeId}")
	public void deleteEmployee(@PathVariable(name = "employeeId")Long employeeId) {
		Employee emp = empService.getEmployee(employeeId);
		if(emp == null) {
			throw new EmployeeException(employeeId);
		}
		empService.deleteEmployee(employeeId);
		HashMap<String, String> map = new HashMap<>();
		map.put("message", "Delete Success !");
	}
	
	@PutMapping("/{employeeId}")
	public void updateEmployee(@PathVariable(name = "employeeId")Long employeeId, @RequestBody Employee employee) {
		Employee emp = empService.getEmployee(employeeId);
		if(emp == null) {
			throw new EmployeeException(employeeId);
		}
		emp.setName(employee.getName());
		emp.setEmail(employee.getEmail());
		emp.setRole(employee.getRole());
		
		empService.updateEmployee(emp);
		
		HashMap<String, String> map = new HashMap<>();
		map.put("message", "Update Success !");
	}

}
