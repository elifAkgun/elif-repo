import mypackage.ServiceShape;
import mypackage.model.Triangle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("mypackage")
@EnableAspectJAutoProxy
public class ConfigClass {
}
