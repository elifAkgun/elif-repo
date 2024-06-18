package code.elif.webfluxdemo.controller;

import org.springframework.stereotype.Service;

@Service
public class YosEventsInnerService {

    public String publishYosEvent(String request)  {


            //publish
            publishYosEvent();


        return "response";
    }
    @Retryable(backoff = @Backoff(delay = 1000L, maxDelay = 10000, multiplier = 2.0), maxAttempts = 3, value = IllegalArgumentException.class)
    public void publishYosEvent() {
        System.out.println("Published event." + new Date());
        throw new IllegalArgumentException();
    }

    @Recover
    public void recoverYosEvent(IllegalArgumentException exc) {
        System.out.println("recover yos event");
    }


}