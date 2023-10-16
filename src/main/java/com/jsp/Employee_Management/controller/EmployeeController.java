package com.jsp.Employee_Management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.Employee_Management.dto.EmployeeRequest;
import com.jsp.Employee_Management.dto.EmployeeResponse;
import com.jsp.Employee_Management.model.Employee;
import com.jsp.Employee_Management.service.EmployeeService;
import com.jsp.Employee_Management.util.ResponseStructure;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<EmployeeResponse>> saveEmployee(@RequestBody @Validated EmployeeRequest employeeRequest)
	{
		return service.saveEmployee(employeeRequest);
	}
//	@PutMapping
//	public Employee updateEmployee(@RequestBody Employee employee,@RequestParam int employeeId)
//	{
//		return service.updateEmployee(employee, employeeId);
//	}
	@PutMapping("/employeeId/{employeeId}")
	public ResponseEntity<ResponseStructure<EmployeeResponse>> updateEmployee(@RequestBody @Validated EmployeeRequest employee,@PathVariable int employeeId)
	{
		return service.updateEmployee(employee, employeeId);
	}
	@GetMapping
	public List<Employee> FindAllEmployee()
	{
		return service.findAllEmployee();
	}
	@DeleteMapping("/employeeId/{employeeId}")
	public ResponseEntity<ResponseStructure<EmployeeResponse>> DeleteEmployeeById(@PathVariable int employeeId)
	{
		return service.deleteEmployee(employeeId);
	}
	@GetMapping("/employeeEmail/{employeeEmail}")
	public Employee findByEmployeeEmail(@PathVariable String employeeEmail) {
		return service.findByEmployeeEmail(employeeEmail);
	}
	@GetMapping("/employeeEmail/{employeeEmail}/employeePassword/{employeePassword}")
	public Employee findByEmployeeEmailAndPassword(@PathVariable String employeeEmail,@PathVariable String employeePassword) {
		return service.findByEmployeeEmailAndPassword(employeeEmail, employeePassword);
	}
}