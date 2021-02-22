package code.elif.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PersonInterceptor implements HandlerInterceptor {

    private  static Logger logger = LoggerFactory.getLogger(PersonInterceptor.class);

    long preHandleTime =0;
    long postHandleTime =0;
    long afterCompletionTime =0;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        preHandleTime = System.currentTimeMillis();
        logger.info("preHandleTime : " + preHandleTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        postHandleTime = System.currentTimeMillis();
        logger.info("postHandleTime : " + postHandleTime);
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        afterCompletionTime = System.currentTimeMillis();
        logger.info("afterCompletionTime : " + afterCompletionTime);
        long totalExecutionTime = afterCompletionTime - preHandleTime;
        logger.info("totalExecutionTime : " + totalExecutionTime + " ms");
    }
}
