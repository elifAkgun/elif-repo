package elif.code.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan(basePackages = "elif.code.model.simple")
@PropertySource(value = {"classpath:organisation.properties"})
public class JavaConfigWithProperty {

}
