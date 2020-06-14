package com.elif.config.exception;

import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

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
		
		if(exception instanceof NotAuthorizedException) {
			 return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage())
		                .build();
		}
		else {
			 return Response.status(Response.Status. NOT_ACCEPTABLE).entity(exception.getMessage()).build();
		}
	}
}
