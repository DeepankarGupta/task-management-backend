package com.stackhack.taskmanagement.restcontrollers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.stackhack.taskmanagement.exceptions.ResourceNotFoundException;
import com.stackhack.taskmanagement.models.response.CustomErrorResponse;
import com.stackhack.taskmanagement.models.response.CustomResponse;

@RestControllerAdvice
public class CustomExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<CustomResponse<Object>> handleResourceNotFound(WebRequest request, ResourceNotFoundException ex) {
		CustomErrorResponse errorResponse = new CustomErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
		CustomResponse<Object> response = new CustomResponse<Object>("Resource not found", HttpStatus.NOT_FOUND, null, errorResponse);
		return new ResponseEntity<CustomResponse<Object>>(response, response.getHttpStatus());
	}
	

}
