package com.elif.config.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.ext.Provider;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class DynamicCacheResponseFilter implements ContainerResponseFilter {

	private CacheControl cacheControl;

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {

		String method = requestContext.getMethod();
		String path = requestContext.getUriInfo().getPath();

		if (method.equalsIgnoreCase("GET") && path.equalsIgnoreCase("customers")) {
			responseContext.getHeaders().add("Cache-Control", cacheControl);
			responseContext.getHeaders().add("MyMessage", "This works fine!! 2");

		}

	}

}
