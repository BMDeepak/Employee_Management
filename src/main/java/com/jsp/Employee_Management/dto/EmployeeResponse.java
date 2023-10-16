package com.jsp.Employee_Management.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class EmployeeResponse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;
	@NotEmpty(message="Invalid Name")
	private String employeeName;
	@NotEmpty(message="Invalid email")
	@Email(regexp = "[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,}", message = "invalid email ")
	private String employeeEmail;

	@Min(value = 6000000000l, message="Phone number cannot be less then 6000000000")
	@Max(value = 9999999999l, message="Phone number cannot be less then 9999999999")
	private long employeePhoneNumber;
	@Min(value = 12000,message="employee salary cannot be less then 12000")
	@Max(value = 12000000,message="employee salary cannot be more then 12000000")
	private double employeeSalary;
	public int getEmployeeId() {
		return employeeId;
	}
	public EmployeeResponse setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
		return this;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public EmployeeResponse setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
		return this;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public EmployeeResponse setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
		return this;
	}
	public long getEmployeePhoneNumber() {
		return employeePhoneNumber;
	}
	public EmployeeResponse setEmployeePhoneNumber(long employeePhoneNumber) {
		this.employeePhoneNumber = employeePhoneNumber;
		return this;
	}
	public double getEmployeeSalary() {
		return employeeSalary;
	}
	public EmployeeResponse setEmployeeSalary(double employeeSalary) {
		this.employeeSalary = employeeSalary;
		return this;
	}
	

}