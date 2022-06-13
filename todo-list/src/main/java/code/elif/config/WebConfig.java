package code.elif.config;

import code.elif.util.Views;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@EnableWebMvc
@ComponentScan(basePackages = "code.elif")
@Configuration
public class WebConfig implements WebMvcConfigurer {
    // == constants ==
    public static final String RESOLVER_PREFIX = "/WEB-INF/view/";
    public static final String RESOLVER_SUFFIX =".jsp";

    // == bean methods
    @Bean
    public ViewResolver viewResolver() {
        UrlBasedViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix(RESOLVER_PREFIX);
        viewResolver.setSuffix(RESOLVER_SUFFIX);
        return viewResolver;
    }

    /***
     * it uses simple automated controllers that preconfigured with
     * a response status code or a view to do render the response body.
     * We configure in the path to the home view and spring will
     * use it without having to create a controller.
     * the parameter of this method is of type and view controller
     * registry. so this class assists with the registration of
     * simple automated controllers that are pre-configured with
     * a status code or a view. we'll call the method to add view
     * controller on the parameter or registry to register the URL
     * with our view.
     ***/
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName(Views.HOME);
    }
}
