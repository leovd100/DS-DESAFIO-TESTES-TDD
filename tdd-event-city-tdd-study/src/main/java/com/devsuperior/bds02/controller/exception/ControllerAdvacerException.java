package com.devsuperior.bds02.controller.exception;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devsuperior.bds02.exception.CityException;
import com.devsuperior.bds02.exception.DataBaseException;
import com.devsuperior.bds02.exception.EventException;

@ControllerAdvice
public class ControllerAdvacerException {

	
	
	@ExceptionHandler(CityException.class)
	public ResponseEntity<StandardError> entityNotFound(CityException entity, HttpServletRequest request){
			
			StandardError standard = new StandardError();
			HttpStatus status = HttpStatus.NOT_FOUND;
			standard.setTimestamp(Instant.now());
			standard.setError("Resource not found");
			standard.setMessage(entity.getMessage());
			standard.setStatus(status.value());
			standard.setPath(request.getRequestURI());	
			return ResponseEntity.status(status).body(standard);

	}
	
	
	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<StandardError> entityNotFound(DataBaseException entity, HttpServletRequest request){
			
			StandardError standard = new StandardError();
			HttpStatus status = HttpStatus.BAD_REQUEST;
			standard.setTimestamp(Instant.now());
			standard.setError("Resource not found");
			standard.setMessage(entity.getMessage());
			standard.setStatus(status.value());
			standard.setPath(request.getRequestURI());	
			return ResponseEntity.status(status).body(standard);

	}
	
	@ExceptionHandler(EventException.class)
	public ResponseEntity<StandardError> entityNotFound(EventException entity, HttpServletRequest request){
			
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
