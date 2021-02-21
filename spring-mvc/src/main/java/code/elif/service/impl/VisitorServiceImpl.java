package code.elif.service.impl;

import code.elif.service.VisitorService;
import org.springframework.stereotype.Service;

@Service
public class VisitorServiceImpl implements VisitorService {

    Integer visitorCount=0;

    @Override
    public void updateVisitorCount() {
        visitorCount = visitorCount+1;
    }

    @Override
    public Integer getVisitorCount() {
        return visitorCount;
    }
}
