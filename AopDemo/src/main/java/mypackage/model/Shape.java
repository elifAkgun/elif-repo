package mypackage.model;


import mypackage.Loggable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public interface Shape {

    @Loggable
    public void getName();
}
