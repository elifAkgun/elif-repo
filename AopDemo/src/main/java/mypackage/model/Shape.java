package mypackage.model;


import mypackage.Loggable;
import org.springframework.stereotype.Component;

@Component
public interface Shape {

    @Loggable
    public void getName();
}
