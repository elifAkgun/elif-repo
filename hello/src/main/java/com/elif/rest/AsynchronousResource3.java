package com.elif.rest;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.CompletionCallback;
import javax.ws.rs.container.ConnectionCallback;
import javax.ws.rs.container.Suspended;

@Stateless
@Path("/asyncresource3")
public class AsynchronousResource3 {
	@Resource
	ManagedExecutorService managedExecutorService;

	@Inject
	Logger logger;

	@GET
	public void asyncRestMethod(@Suspended final AsyncResponse asyncResponse) {
		asyncResponse.register(new CompletionCallback() {
			@Override
			public void onComplete(Throwable throwable) {
				if (throwable == null) {
		            logger.log(Level.INFO, "Everything is good. Response has been successfully dispatched to client");
	 
				} else {
		            logger.log(Level.INFO, "An error has occurred during request processing");

				}
			}
		}, new ConnectionCallback() {
			public void onDisconnect(AsyncResponse disconnected) {
	            logger.log(Level.INFO, "Connection lost or closed by the client!");
			}
		});
		managedExecutorService.submit(new Runnable() {
			@Override
			public void run() {
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
		});
	}
}