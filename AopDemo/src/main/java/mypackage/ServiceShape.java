package mypackage;

import mypackage.model.Shape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class ServiceShape {

    @Autowired
    private Shape triangle;

    public void getShapeName() {
        triangle.getName();
    }
}
