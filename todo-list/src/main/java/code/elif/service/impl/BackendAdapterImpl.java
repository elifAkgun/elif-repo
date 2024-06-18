package code.elif.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;

@Slf4j
@Service
public class BackendAdapterImpl implements BackendAdapter {

    @Override
    public String getBackendResponse(String param1, String param2) {

        int random = new Random().nextInt(4);
        throw new RemoteServiceNotAvailableException("Remote API failed");
    }

    @Override
    public String getBackendResponseFallback(RemoteServiceNotAvailableException e, String param1, String param2) {
        return "Hello from fallback method!!!";
    }
}