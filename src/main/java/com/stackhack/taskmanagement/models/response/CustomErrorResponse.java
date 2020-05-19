package com.stackhack.taskmanagement.models.response;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CustomErrorResponse {
	
	@JsonIgnore
	private HttpStatus httpStatus;
	
	private int code;
	private String message;
	private List<Error> errors;
	
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}

	public CustomErrorResponse(HttpStatus httpStatus, String message) {
		super();
		this.httpStatus = httpStatus;
		this.code = this.httpStatus.value();
		this.message = message;
		this.errors = null;
	}

	private static final class Error {
		private final String domain;
        private final String reason;
        private final String message;
        private final String sendReport;
        
		public Error(String domain, String reason, String message, String sendReport) {
			super();
			this.domain = domain;
			this.reason = reason;
			this.message = message;
			this.sendReport = sendReport;
		}
        
	}
	
}
