package code.elif.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import javax.sql.DataSource;
import java.security.PublicKey;
import java.util.List;

@Configuration
@ComponentScan("code.elif")
@EnableWebMvc //<mvc:annotation-driven>
//This class is used instead of spring-mvc-servlet.xml
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Bean
    public DataSource dataSource() {
        final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
        dsLookup.setResourceRef(true);
        DataSource dataSource = dsLookup.getDataSource("jdbc/spring_db");
        return dataSource;
    }

    @Bean
    public UrlBasedViewResolver urlBasedViewResolver(){
        UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver();
        urlBasedViewResolver.setPrefix("/WEB-INF/views/");
        urlBasedViewResolver.setSuffix(".jsp");
        urlBasedViewResolver.setViewClass(JstlView.class);
        return urlBasedViewResolver;
    }

    @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping(){
        RequestMappingHandlerMapping rmhm = new RequestMappingHandlerMapping();
        rmhm.setUseSuffixPatternMatch(false);
        rmhm.setUseTrailingSlashMatch(false);
        return rmhm;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
        //<mvc:view-controller path="/" viewName="home"/>
    }
}
