package com.elif.rest;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

@Stateless
@Path("/asyncresource")
public class AsynchronousResource {
   @GET
   @Asynchronous
    public void asyncRestMethod(@Suspended final AsyncResponse asyncResponse) {
                String result = heavyLifting();
                asyncResponse.resume(result);
            }
     private String heavyLifting() {
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                return "RESULT";
      }
}