package com.jmdiaz.course.catalog.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Mapper exception to ValidationException
 * @author kentaro
 *
 */
@Provider
public class CustomInvalidParametersMapper implements ExceptionMapper<InvalidParametersException> {
	private static final Logger logger = LoggerFactory.getLogger(CustomInvalidParametersMapper.class);
    
	/**
	 * Handle error
	 */
    @Override
    public Response toResponse(InvalidParametersException ex) {
        MessageError message = new MessageError();
        logger.error(ex.getMessage(),ex);
        // Trace original exception
        message.setHttpError(ex.getHttpError());
        message.setMessage(ex.getMessage());
        return Response.status(ex.getHttpError()).entity(message).type(MediaType.APPLICATION_JSON).build();
    }
}