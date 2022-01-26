package mypackage;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {

    @Before("@annotation(Loggable)")
    public void LoggingAdvice(){
        System.out.println("Running Advice ");
    }
}
