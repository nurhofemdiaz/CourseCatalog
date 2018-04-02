package com.jmdiaz.course.catalog.exception;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * POJO to messages error
 * 
 * @author kentaro
 *
 */
public class MessageError {

	private int httpError;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("httpError", httpError).append("message", message).toString();
	}

	public int getHttpError() {
		return httpError;
	}

	public void setHttpError(int httpError) {
		this.httpError = httpError;
	}

}
