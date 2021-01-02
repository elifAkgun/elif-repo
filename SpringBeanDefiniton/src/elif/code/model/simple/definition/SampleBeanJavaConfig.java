package elif.code.model.simple.definition;

import org.springframework.beans.factory.annotation.Value;

import lombok.ToString;

@ToString
public class SampleBeanJavaConfig {

    @Value("Sample Bean with Java Config!!!")
    private String str;

}
