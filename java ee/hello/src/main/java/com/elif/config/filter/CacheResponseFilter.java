package com.elif.config.filter;
//package com.elif.config;
//
//import javax.ws.rs.container.ContainerRequestContext;
//import javax.ws.rs.container.ContainerResponseContext;
//import javax.ws.rs.container.ContainerResponseFilter;
//import javax.ws.rs.core.CacheControl;
//import javax.ws.rs.ext.Provider;
//import java.io.IOException;
//
//
//
//@Provider
//public class CacheResponseFilter implements ContainerResponseFilter {
//    @Override
//    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
//
//        String method = requestContext.getMethod();
//        String path = requestContext.getUriInfo().getPath();
//
//        if (method.equalsIgnoreCase("GET") && path.equalsIgnoreCase("customers")) {
//            CacheControl cacheControl = new CacheControl();
//            cacheControl.setMaxAge(90);
//            cacheControl.setPrivate(true);
//
//            responseContext.getHeaders().add("Cache-Control", cacheControl);
//            responseContext.getHeaders().add("MyMessage","This works fine!! 1" );
//
//        }
//
//
//    }
//}
