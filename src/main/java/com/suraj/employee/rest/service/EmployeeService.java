package com.suraj.employee.rest.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.data.domain.PageRequest;

import com.suraj.employee.rest.model.Employee;

public interface EmployeeService {

	public Employee getEmployeeById(Integer id);

	public Employee createEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public void deleteEmployeeById(Integer id);

	public void deleteAllEmployees();

	public Employee updateEmployeeById(Employee employee, Integer employeeId);

	public List<Employee> findEmployeesByAddress(String string);

	public List<Employee> findEmployeesByAddressAndDept(String string, int i);

	public List<Employee> findEmployeeByDeptNum(int deptNum, PageRequest pageRequest);

	public CompletableFuture<Employee> findByAddress(String address);
 
	public List<Employee> findByEmployeeNameOrAddress(String employeeName, String address);

}
