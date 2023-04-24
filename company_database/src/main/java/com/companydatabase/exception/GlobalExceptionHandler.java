package com.companydatabase.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.companydatabase.response.ExceptionResponse;

@RestControllerAdvice

public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
public ResponseEntity<ExceptionResponse>resourceNotFoundExceptionHandler(ResourceNotFoundException resourceNotFoundException){
	String message=resourceNotFoundException.getMessage();
	ExceptionResponse exceptionResponse=new ExceptionResponse(message ,false);
	return new ResponseEntity<ExceptionResponse>(exceptionResponse,HttpStatus.NOT_FOUND);
}
	
}
