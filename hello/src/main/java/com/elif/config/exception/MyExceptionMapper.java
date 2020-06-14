package com.elif.config.exception;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.HashMap;
import java.util.Map;

@Provider
public class MyExceptionMapper implements ExceptionMapper<Exception> {
	@Override
	public Response toResponse(Exception exception) {

		if (exception instanceof ConstraintViolationException) {

			final Map<String, String> constraintViolations = new HashMap<>();

			for (ConstraintViolation<?> cv : ((ConstraintViolationException) exception).getConstraintViolations()) {
				String path = cv.getPropertyPath().toString();
				constraintViolations.put(path, cv.getMessage());
			}

			return Response.status(Response.Status.PRECONDITION_FAILED).entity(constraintViolations).build();
		}
		
		if(exception instanceof NotAuthorizedException || exception instanceof SecurityException ) {
			 return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getLocalizedMessage()).type(MediaType.TEXT_PLAIN)
		                .build();
		}
		else {
			 return Response.status(Response.Status. NOT_ACCEPTABLE).type(MediaType.TEXT_PLAIN).entity(exception.getLocalizedMessage()).build();
		}
	}
}
