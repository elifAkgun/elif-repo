package elif.code.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import elif.code.model.simple.definition.SampleBeanJavaConfig;

@Configuration
public class JavaConfigSimple {

    @Bean(name = "mySampleBean")
    public SampleBeanJavaConfig mySampleBean() {
        return new SampleBeanJavaConfig();
    }
}
