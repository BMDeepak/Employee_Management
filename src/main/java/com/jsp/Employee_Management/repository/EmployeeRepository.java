package com.jsp.Employee_Management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.Employee_Management.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	public Optional<Employee> findByEmployeeEmail(String employeeEmail);
	
	@Query("select e from Employee e where e.employeeEmail=?1 and e.employeePassword=?2")
	public Optional<Employee> findByEmployeeEmailAndPassword(String employeeEmail,String employeePassword);

}