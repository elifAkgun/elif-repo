package code.elif.interceptor;

import junit.textui.TestRunner;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;


@Service
public class VisitorInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        request.setAttribute("time", LocalDateTime.now());
        HttpSession session = request.getSession(true);
        if (session.getAttribute("sessionStartTime") == null) {
            session.setAttribute("sessionStartTime", LocalDateTime.now());
        }


        return true;

    }


}


