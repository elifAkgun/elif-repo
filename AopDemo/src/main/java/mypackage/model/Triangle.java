package mypackage.model;

import mypackage.Loggable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class Triangle implements Shape {

    public void getName() {
        System.out.println("Triangle");
    }
}
