package com.jsp.Employee_Management.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jsp.Employee_Management.dto.EmployeeRequest;
import com.jsp.Employee_Management.dto.EmployeeResponse;
import com.jsp.Employee_Management.model.Employee;
import com.jsp.Employee_Management.util.ResponseStructure;

public interface EmployeeService {
	ResponseEntity<ResponseStructure<EmployeeResponse>> saveEmployee(EmployeeRequest employeeRequest);
	
	Employee findEmployeebyid(int employeeId);
	
	List<Employee> findAllEmployee();
	
	ResponseEntity<ResponseStructure<EmployeeResponse>> deleteEmployee(int employeeId);

	Employee deleteEmployeeById(int employeeId);
	
	Employee findByEmployeeEmail(String employeeEmail);
	
	Employee findByEmployeeEmailAndPassword(String employeeEmail,String employeePassword);

	ResponseEntity<ResponseStructure<EmployeeResponse>> updateEmployee(EmployeeRequest employee, int employeeId);

}