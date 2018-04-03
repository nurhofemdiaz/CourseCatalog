package com.jmdiaz.course.catalog.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jmdiaz.course.catalog.utils.Messages;

/**
 * Mapper exception to ValidationException
 * @author kentaro
 *
 */
@Provider
public class CustomValidationExceptionMapper implements ExceptionMapper<javax.validation.ValidationException> {
	private static final Logger logger = LoggerFactory.getLogger(CustomValidationExceptionMapper.class);
    
	/**
	 * Handle error
	 */
	public Response toResponse(javax.validation.ValidationException e) {
		MessageError message = new MessageError();
		// Trace original exception
		logger.error(e.getMessage(),e);
		
		// Launch Bad Request HTTP
		message.setHttpError(Response.Status.BAD_REQUEST.getStatusCode());
		message.setMessage(Messages.BAD_REQUEST_MESSAGES.getMessage());
		return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(message)
				.type(MediaType.APPLICATION_JSON).build();
	}
}
