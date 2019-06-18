package com.suraj.employee.rest.service.impl;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.suraj.employee.rest.dao.EmployeeDao;
import com.suraj.employee.rest.model.Employee;
import com.suraj.employee.rest.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public Employee getEmployeeById(Integer id) {
		return employeeDao.getOne(id);
	}

	@Override
	public Employee createEmployee(Employee employee) {
		return employeeDao.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDao.findAll();
	}

	@Override
	public void deleteEmployeeById(Integer id) {
		employeeDao.delete(id);
	}

	@Override
	public void deleteAllEmployees() {
		employeeDao.deleteAll();
	}

	@Override
	public Employee updateEmployeeById(Employee employee, Integer employeeId) {
		return employeeDao.save(employee);
	}

	@Override
	public List<Employee> findEmployeesByAddress(String address) {
		//return employeeDao.findByAddress(address);
		return employeeDao.findEmployeeByAddress(address);
	}

	@Override
	public List<Employee> findEmployeesByAddressAndDept(String address, int deptNum) {
		//return employeeDao.findByAddressAndDeptNum(address, deptNum);
		return employeeDao.findEmployeeByAddressAndDeptNum(address, deptNum);
	}

	@Override
	public List<Employee> findEmployeeByDeptNum(int deptNum, PageRequest pageRequest) {
		return employeeDao.findByDeptNum(deptNum, pageRequest);
	}

	@Override
	public CompletableFuture<Employee> findByAddress(String address) {
		return employeeDao.findByAddress(address);
	}

	@Override
	public List<Employee> findByEmployeeNameOrAddress(String employeeName,
			String address) {
		return employeeDao.findByEmployeeNameOrAddress(employeeName, address);
	}

}
