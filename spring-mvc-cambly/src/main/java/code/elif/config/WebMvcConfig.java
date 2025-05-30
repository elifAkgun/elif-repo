package code.elif.config;

import code.elif.interceptor.CamblyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@ComponentScan("code.elif")
@EnableWebMvc //<mvc:annotation-driven>
//This class is used instead of spring-mvc-servlet.xml
public class WebMvcConfig extends WebMvcConfigurerAdapter {

//    @Bean
//    public DataSource dataSource() {
//        final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
//        dsLookup.setResourceRef(true);
//        DataSource dataSource = dsLookup.getDataSource("jdbc/cambly");
//        return dataSource;
//    }

    @Bean
    public UrlBasedViewResolver urlBasedViewResolver() {
        UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver();
        urlBasedViewResolver.setPrefix("/WEB-INF/views/");
        urlBasedViewResolver.setSuffix(".jsp");
        urlBasedViewResolver.setViewClass(JstlView.class);
        return urlBasedViewResolver;
    }

//    @Bean
//    public RequestMappingHandlerMapping requestMappingHandlerMapping(){
//        RequestMappingHandlerMapping rmhm = new RequestMappingHandlerMapping();
//        rmhm.setUseSuffixPatternMatch(false);
//        rmhm.setUseTrailingSlashMatch(false);
//        return rmhm;
//    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
        //<mvc:view-controller path="/" viewName="home"/>
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CamblyInterceptor());
    }
}
