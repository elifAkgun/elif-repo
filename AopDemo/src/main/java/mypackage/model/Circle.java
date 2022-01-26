package mypackage.model;

import mypackage.Loggable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("circle")
public class Circle implements Shape {

    @Loggable
    public void getName() {
        System.out.println("Circle");
    }
}
