package com.example.demo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<MyErrorDetails> commentNotFoundHandler(StudentNotFoundException c, WebRequest wr) {
		return new ResponseEntity<MyErrorDetails>(new MyErrorDetails(LocalDateTime.now(), c.getMessage(), wr.getDescription(false)), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CourseNotFoundException.class)
	public ResponseEntity<MyErrorDetails> commentNotFoundHandler(CourseNotFoundException p, WebRequest wr) {
		return new ResponseEntity<MyErrorDetails>(new MyErrorDetails(LocalDateTime.now(),p.getMessage(),wr.getDescription(false)), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(StudentCredentialsNotValidException.class)
	public ResponseEntity<MyErrorDetails> studentCredentialsNotValidHandler(StudentCredentialsNotValidException p, WebRequest wr) {
		return new ResponseEntity<MyErrorDetails>(new MyErrorDetails(LocalDateTime.now(),p.getMessage(),wr.getDescription(false)), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> myExpHandler2(NoHandlerFoundException e, WebRequest wr)
	{
		return new ResponseEntity<MyErrorDetails>(new MyErrorDetails(LocalDateTime.now(),e.getMessage(),wr.getDescription(false)), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> myExpHandler3(MethodArgumentNotValidException me, WebRequest wr) {
		return new ResponseEntity<MyErrorDetails>(new MyErrorDetails(LocalDateTime.now(),me.getMessage(),wr.getDescription(false)), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> myExpHandler(Exception e, WebRequest wr){
		return new ResponseEntity<MyErrorDetails>(new MyErrorDetails(LocalDateTime.now(),e.getMessage(),wr.getDescription(false)), HttpStatus.NOT_FOUND);
	}
}
