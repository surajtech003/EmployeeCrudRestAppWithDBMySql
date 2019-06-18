package com.suraj.employee.rest.dao;

import java.util.List;
import java.util.concurrent.CompletableFuture;


import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import com.suraj.employee.rest.model.Employee;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer>, JpaRepository<Employee, Integer> {

	//public List<Employee> findByAddress(String address); 
	//public List<Employee> findByAddressAndDeptNum(String address, int deptNum);
	
	//@Query(value="SELECT e FROM Employee e WHERE e.address = ?1")
	//@Query(value="SELECT * FROM employee_table WHERE addr = ?1", nativeQuery = true)
	@Query("SELECT e FROM Employee e WHERE e.address =:address")
	public List<Employee> findEmployeeByAddress(String address);
	
	//@Query(value="SELECT e FROM Employee e WHERE e.address = ?1 AND e.deptNum = ?2")
	//@Query(value="SELECT * FROM employee_table WHERE addr = ?1 AND dept = ?2", nativeQuery = true)
	@Query("SELECT e FROM Employee e WHERE e.address =:address OR e.deptNum =:deptNum")
	public List<Employee> findEmployeeByAddressAndDeptNum(String address, int deptNum);

	public List<Employee> findByDeptNum(int deptNum, Pageable pageable);

	@Async
	public CompletableFuture<Employee> findByAddress(String address); 
	
	@Query("SELECT e FROM Employee e WHERE e.employeeName =:employeeName OR e.address =:address")
	public List<Employee> findByEmployeeNameOrAddress(@Param("employeeName") String employeeName, @Param("address") String address);

}
