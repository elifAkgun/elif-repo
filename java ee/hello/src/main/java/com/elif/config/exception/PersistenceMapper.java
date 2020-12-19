//package com.elif.config.exception;
//
//import java.sql.SQLException;
//
//import javax.ws.rs.core.Response;
//import javax.ws.rs.ext.ExceptionMapper;
//import javax.ws.rs.ext.Provider;
//
//@Provider
//public class PersistenceMapper implements ExceptionMapper<SQLException> {
//
//	@Override
//	public Response toResponse(SQLException arg0) {
//        return Response.status(Response.Status. NOT_ACCEPTABLE).entity(arg0.getMessage()).build();
//	}	
//}
