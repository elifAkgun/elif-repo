package code.elif.interceptor;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CamblyInterceptor implements HandlerInterceptor {

    private  static Logger logger = LoggerFactory.getLogger(CamblyInterceptor.class);

    long preHandleTime =0;
    long postHandleTime =0;
    long afterCompletionTime =0;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        preHandleTime = System.currentTimeMillis();
        logger.error("preHandleTime : " + preHandleTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        postHandleTime = System.currentTimeMillis();
        logger.debug("postHandleTime :  " + postHandleTime);
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        afterCompletionTime = System.currentTimeMillis();
        logger.debug("afterCompletionTime : " + afterCompletionTime);
        long totalExecutionTime = afterCompletionTime - preHandleTime;
        logger.debug("totalExecutionTime : " + totalExecutionTime);
    }
}
