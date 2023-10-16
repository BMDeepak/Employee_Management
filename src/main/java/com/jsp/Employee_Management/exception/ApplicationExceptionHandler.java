package com.jsp.Employee_Management.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jsp.Employee_Management.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler{
	
	@Autowired
	private ResponseStructure<String> responseStructure;
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		List<ObjectError> allErrors = ex.getAllErrors();
		
		Map<String, String> errors= new HashMap<>();
		
		for (ObjectError error : allErrors) {
			String message = error.getDefaultMessage();
			FieldError fieldError = (FieldError) error;
			String fieldName = fieldError.getField();
			errors.put(fieldName, message);
		}
		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler
	public ResponseEntity< ResponseStructure<String>> EmployeeNotFoundById(EmployeeNotFoundByIdException ex) {
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(ex.getMessage());
		responseStructure.setData("Employee Not Found with requested Id!!");
		return new ResponseEntity<>(responseStructure,HttpStatus.NOT_FOUND);
	}

}