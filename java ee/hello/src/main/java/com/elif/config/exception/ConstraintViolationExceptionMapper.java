package com.elif.config.exception;

import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ValidationException> {
	@Override
	public Response toResponse(ValidationException exception) {

		if (exception instanceof ConstraintViolationException) {

			final Map<String, String> constraintViolations = new HashMap<>();

			for (ConstraintViolation<?> cv : ((ConstraintViolationException) exception).getConstraintViolations()) {
				String path = cv.getPropertyPath().toString();
				constraintViolations.put(path, cv.getMessage());
			}
			return Response.status(Response.Status.PRECONDITION_FAILED).entity(constraintViolations).build();
		}
		
		else {
			return Response.status(Response.Status.PRECONDITION_FAILED).build();

		}
	}
}
