package com.tinnt.RestAPI_Demo.exception;

public class EmployeeException extends RuntimeException{
	public EmployeeException(long id) {
		super("Could not be found employee ith id: "+id);
	}
}
