package com.jmdiaz.course.catalog.utils;

public enum Messages {
	BAD_REQUEST_MESSAGES("Invalid parameters")
	, GENERAL_ERROR_MESSAGES("General error");
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	private Messages(String message) {
		this.message = message;
	}

}
