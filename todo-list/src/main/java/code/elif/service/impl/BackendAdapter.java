package code.elif.service.impl;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;

public interface BackendAdapter {

    @Retryable(retryFor = {RemoteServiceNotAvailableException.class},
            maxAttempts = 3,
            backoff = @Backoff(delay = 1000))
    String getBackendResponse(String param1, String param2);

    @Recover
    String getBackendResponseFallback(RemoteServiceNotAvailableException e, String param1, String param2);
}