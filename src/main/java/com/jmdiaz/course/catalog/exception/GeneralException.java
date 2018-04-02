package com.jmdiaz.course.catalog.exception;

/**
 * Non functional error. Technical error. Can store http error code
 * 
 * @author kentaro
 *
 */
public class GeneralException extends Exception {

	/**
	 * Calculated sereial UID
	 */
	private static final long serialVersionUID = -2566171807424023809L;
	int httpError;

	public GeneralException() {
	}

	public GeneralException(int httpError, String message) {
		super(message);
		this.httpError = httpError;
	}

	public int getHttpError() {
		return httpError;
	}

	public void setHttpError(int httpError) {
		this.httpError = httpError;
	}

}
