package com.suraj.employee.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suraj.employee.rest.model.Employee;
import com.suraj.employee.rest.service.EmployeeService;

@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping(value="/welcome")
	public String welcome() {
		return "welcome to employee crud api using spring boot";
	}
	
	@PostMapping(value="/create")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	}
	
	@GetMapping(value="/get/{id}", produces="application/json")
	public Employee getEmployeeById(@PathVariable("id") Integer id) {
		return employeeService.getEmployeeById(id);
	}
	
	@GetMapping(value="/getAll", produces="application/json")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
	
	@DeleteMapping(value="/delete/{id}")
	public boolean deleteEmployeeById(@PathVariable("id") Integer id) {
		 employeeService.deleteEmployeeById(id);
		 return true;
	}
	
	@DeleteMapping(value="/deleteAll")
	public void deleteAllEmployees() {
		 employeeService.deleteAllEmployees();
	}
	
	@PutMapping(value="/update")
	public Employee updateEmployeeById(@RequestBody Employee employee) {
		 Employee emp = employeeService.getEmployeeById(employee.getEmployeeId());
		 if (emp != null) {
			emp = employeeService.updateEmployeeById(employee, employee.getEmployeeId());
		 }
		 return emp;
	}
	
}
