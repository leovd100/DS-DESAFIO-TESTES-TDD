package com.devsuperior.bds01.controller.exception;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devsuperior.bds01.exceptions.DepartmentException;

@ControllerAdvice
public class DepartmentControllerException {
	
	@ExceptionHandler(DepartmentException.class)
	public ResponseEntity<StandardError> entityNotFound(DepartmentException entity, HttpServletRequest request){
			
			StandardError standard = new StandardError();
			HttpStatus status = HttpStatus.NOT_FOUND;
			standard.setTimestamp(Instant.now());
			standard.setError("Resource not found");
			standard.setMessage(entity.getMessage());
			standard.setStatus(status.value());
			standard.setPath(request.getRequestURI());	
			return ResponseEntity.status(status).body(standard);

	}
}
