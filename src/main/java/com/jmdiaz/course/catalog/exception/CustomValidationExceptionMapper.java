package com.jmdiaz.course.catalog.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.jmdiaz.course.catalog.utils.Messages;

@Provider
public class CustomValidationExceptionMapper implements ExceptionMapper<javax.validation.ValidationException> {

	public Response toResponse(javax.validation.ValidationException e) {
		MessageError message = new MessageError();
		message.setHttpError(Response.Status.BAD_REQUEST.getStatusCode());
		message.setMessage(Messages.BAD_REQUEST_MESSAGES.getMessage());
		return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(message)
				.type(MediaType.APPLICATION_JSON).build();
	}
}
