package com.elif.rest;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedThreadFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.container.TimeoutHandler;
import javax.ws.rs.core.Response;

@Stateless
@Path("/asyncresource2")
public class AsynchronousResource2 {
	@Resource(lookup = "java:comp/DefaultManagedThreadFactory")
    private ManagedThreadFactory threadFactory;
	
    @GET
    public void asyncRestMethod(@Suspended final AsyncResponse asyncResponse) {
        asyncResponse.setTimeoutHandler(new TimeoutHandler() {
            @Override
            public void handleTimeout(AsyncResponse asyncResponse) {
                asyncResponse.resume(Response.status
                                     (Response.Status.SERVICE_UNAVAILABLE)
                        .entity("TIME OUT !").build());
            }
        });
        
        asyncResponse.setTimeout(40, TimeUnit.SECONDS);
        
        Thread thread = threadFactory.newThread(new Runnable() {
            @Override
            public void run() {
                String result = heavyLifting();
                asyncResponse.resume(result);
            }
            private String heavyLifting() {
                return "RESULT";
            }
        });
        thread.start();
    }
}