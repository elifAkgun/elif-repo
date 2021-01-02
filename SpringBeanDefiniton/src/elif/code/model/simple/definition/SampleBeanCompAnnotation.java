package elif.code.model.simple.definition;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.ToString;

@ToString
@Component("mySampleBeanCompAnnotation")
public class SampleBeanCompAnnotation {

    @Value("This is my sample bean with component annotation!!")
    private String str;
}
