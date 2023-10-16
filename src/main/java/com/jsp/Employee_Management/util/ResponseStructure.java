package com.jsp.Employee_Management.util;

import org.springframework.stereotype.Component;

@Component
public class ResponseStructure<T> {
	private int status;
	private String message;
	private Object Data;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return Data;
	}
	public void setData(T data) {
		Data = data;
	}
}