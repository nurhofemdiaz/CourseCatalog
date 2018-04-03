package com.jmdiaz.course.catalog.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Mapper exception to GeneralException
 * @author kentaro
 *
 */
@Provider
public class CustomGeneralExceptionMapper implements ExceptionMapper<GeneralException> {
	private static final Logger logger = LoggerFactory.getLogger(CustomGeneralExceptionMapper.class);

	/**
	 * Handle error
	 */
    @Override
    public Response toResponse(GeneralException ex) {
        MessageError message = new MessageError();
        // Trace original exception
        logger.error(ex.getMessage(),ex);
        message.setHttpError(ex.getHttpError());
        message.setMessage(ex.getMessage());
        return Response.status(ex.getHttpError()).entity(message).type(MediaType.APPLICATION_JSON).build();
    }
}