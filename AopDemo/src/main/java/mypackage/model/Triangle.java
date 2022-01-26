package mypackage.model;

import mypackage.Loggable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("triangle")
public class Triangle implements Shape {

    @Loggable
    public void getName() {
        System.out.println("Triangle");
    }
}
