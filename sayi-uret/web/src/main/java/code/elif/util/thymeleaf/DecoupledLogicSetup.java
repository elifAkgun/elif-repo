package code.elif.util.thymeleaf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

import javax.annotation.PostConstruct;

/**
 * if you recall with JSP with JSP files we use a
 * view resolver to set up the prefix and
 * suffix now there is something similar to
 * view resolver but it's used to resolve
 * the templates from the templates
 * directory so in other words the spring
 * resource template resolver is a class
 * that will find the template in the
 * templates directory when the controller
 * returns the view name
 */
@Slf4j
@Component
public class DecoupledLogicSetup {

    private SpringResourceTemplateResolver templateResolver;

    @Autowired
    public DecoupledLogicSetup(SpringResourceTemplateResolver springResourceTemplateResolver) {
        this.templateResolver = springResourceTemplateResolver;
    }

    @PostConstruct
    public void init(){
        templateResolver.setUseDecoupledLogic(true);
        log.info("Decoupled Template Logic enabled ");
    }
}
