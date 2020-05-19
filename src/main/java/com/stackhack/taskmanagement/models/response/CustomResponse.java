package com.stackhack.taskmanagement.models.response;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CustomResponse<T> {
	
	private String message;
	
	@JsonIgnore
	private HttpStatus httpStatus;
	
	private int status;
	private T data;
	private CustomErrorResponse error;

	public CustomResponse(String message, HttpStatus httpStatus, T data, CustomErrorResponse error) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
		this.status = this.httpStatus.value();
		this.data = data;
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public CustomErrorResponse getError() {
		return error;
	}

	public void setError(CustomErrorResponse error) {
		this.error = error;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
}
