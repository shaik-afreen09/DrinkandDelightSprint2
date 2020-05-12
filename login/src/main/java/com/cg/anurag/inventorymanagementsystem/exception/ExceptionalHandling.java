package com.cg.anurag.inventorymanagementsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionalHandling{
	@ResponseBody
	@ResponseStatus(value=HttpStatus.OK)
	@ExceptionHandler(NotFoundOperation.class) 
	public ResponseEntity<String> unsuccessfulOperation(NotFoundOperation e) { return new
	  ResponseEntity<>(e.getMessage(), HttpStatus.OK); }
	 
}
