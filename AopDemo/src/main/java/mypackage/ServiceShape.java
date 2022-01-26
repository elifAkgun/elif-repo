package mypackage;

import mypackage.model.Shape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class ServiceShape {

    private Shape shape;

    @Autowired
    public ServiceShape(@Qualifier("circle") Shape shape){
        this.shape = shape;
    }

    @Loggable
    public Shape findShape() {
        System.out.println("Inside find shape");
        return shape;
    }

}
