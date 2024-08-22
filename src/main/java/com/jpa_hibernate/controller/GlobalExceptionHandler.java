package com.jpa_hibernate.controller;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleException(MethodArgumentNotValidException ex){
		
		
		var errors = new HashMap<String,String>();
		ex.getBindingResult().getAllErrors()
		.forEach(error->{
			
			var fieldName = ((FieldError)error).getField();
			var errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
			
		});
		
		return new  ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
		
	}
}
