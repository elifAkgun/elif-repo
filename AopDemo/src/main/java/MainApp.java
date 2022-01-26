import mypackage.ServiceShape;
import mypackage.model.Shape;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigClass.class);

        ServiceShape serviceShape = ctx.getBean(ServiceShape.class);

        Shape shape = serviceShape.findShape();

        shape.getName();

        serviceShape.findShape();
    }
}
