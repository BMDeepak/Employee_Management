package com.jsp.Employee_Management.exception;

public class EmployeeNotFoundByIdException extends RuntimeException{
	private String message;

	public EmployeeNotFoundByIdException(String message) {
		super();
		this.message = message;
	}
	 public String getMessage() {
		 return message;
	 }
}