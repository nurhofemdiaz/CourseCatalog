package com.jmdiaz.course.catalog.exception;

import javax.ws.rs.core.Response;

/**
 * This exception occurs when validate a invalid input parameter. Store http
 * error code to throw
 * 
 * @author kentaro
 *
 */
public class InvalidParametersException extends Exception {

	/**
	 * Calculated sereial UID
	 */
	private static final long serialVersionUID = -8299536973012569867L;

	int httpError = Response.Status.BAD_REQUEST.getStatusCode();

	public InvalidParametersException() {
	}

	public InvalidParametersException( String message ) {
		super(message);

	}

	public int getHttpError() {
		return httpError;
	}
}
