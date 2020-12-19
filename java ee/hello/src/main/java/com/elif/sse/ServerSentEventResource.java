package com.elif.sse;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.sse.OutboundSseEvent;
import javax.ws.rs.sse.Sse;
import javax.ws.rs.sse.SseBroadcaster;
import javax.ws.rs.sse.SseEventSink;

@ApplicationScoped
@Path("sse-path")
public class ServerSentEventResource {
    
	@Context
    private Sse sse;
    
    @Inject
    private Logger logger;
    private SseBroadcaster sseBroadcaster;
    private SseEventSink eventSink;

    @PostConstruct
    private void init() {
        sseBroadcaster = sse.newBroadcaster();
    }

    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public void fetch(@Context SseEventSink sseEventSink) {
        sseBroadcaster.register(sseEventSink);
        this.eventSink = sseEventSink;

        logger.log(Level.INFO,"SSE opened!" );
    }

   
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public Response broadcastEmployee(String employee) {
        OutboundSseEvent broadcastEvent = sse.newEventBuilder().name("customer").data(employee).
                mediaType(MediaType.TEXT_PLAIN_TYPE).build();

        sseBroadcaster.broadcast(broadcastEvent);
        return Response.ok().status(Response.Status.OK).build();
    }


    @PreDestroy
    private void destroy() {
        if (eventSink != null) {
            eventSink.close();

        }
    }

}
