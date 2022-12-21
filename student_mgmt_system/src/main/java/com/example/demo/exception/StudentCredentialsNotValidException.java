package com.example.demo.exception;

public class StudentCredentialsNotValidException extends RuntimeException{
	public StudentCredentialsNotValidException() {
		
	}
	
	public StudentCredentialsNotValidException(String message) {
		super(message);
	}
}
