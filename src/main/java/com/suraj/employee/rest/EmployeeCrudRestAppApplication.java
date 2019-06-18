package com.suraj.employee.rest;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.scheduling.annotation.EnableAsync;

import com.suraj.employee.rest.model.Employee;
import com.suraj.employee.rest.service.EmployeeService;

@SpringBootApplication
@EnableAsync
public class EmployeeCrudRestAppApplication implements CommandLineRunner {

	@Autowired
	private EmployeeService employeeService;
	
	public static void main(String[] args) {

		SpringApplication.run(EmployeeCrudRestAppApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		//findEmployeesByAddress();
		//findEmployeeByAddressAndDept();
		findEmployeeByDeptNum();
		//findByAddress();
		//findByEnameOrAddress();
		
	}

	private void findByEnameOrAddress() {
		List<Employee> list = employeeService.findByEmployeeNameOrAddress("suraj","Bangalore");
		list.forEach(System.out::println);
	}

	private void findByAddress() throws InterruptedException, ExecutionException, TimeoutException {
		CompletableFuture<Employee> completableFuture = employeeService.findByAddress("Kaithal");
		Employee emp = completableFuture.get(20, TimeUnit.SECONDS);
		System.out.println(emp);
	}

	private void findEmployeeByDeptNum() {
		List<Employee> list = employeeService.findEmployeeByDeptNum(10, new PageRequest(0, 4, Direction.ASC, "employeeName"));
		list.forEach(System.out::println);		
	}

	private void findEmployeeByAddressAndDept() {
		List<Employee> list = employeeService.findEmployeesByAddressAndDept("Bangalore",10);
		list.forEach(System.out::println);
		
	}

	private void findEmployeesByAddress() {
		List<Employee> list = employeeService.findEmployeesByAddress("Reeva");
		list.forEach(System.out::println);
	}

}