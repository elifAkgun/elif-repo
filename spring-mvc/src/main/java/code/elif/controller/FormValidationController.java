package code.elif.controller;

import code.elif.model.OrganizationRepresentative;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/validationDemo")
public class FormValidationController {

    private static Logger logger = LoggerFactory.getLogger(FormValidationController.class);

    @RequestMapping("/home")
    public ModelAndView home(Model model) {
        return new ModelAndView("formValidationHome", "orgRep", new OrganizationRepresentative());
    }


    @RequestMapping("/registerOrgRep")
    public String organizationRepresentativeRegister(@Valid @ModelAttribute("orgRep") OrganizationRepresentative organizationRepresentative,
                                                     BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("form", bindingResult.getAllErrors());

            for (FieldError f : bindingResult.getFieldErrors()) {
                logger.info("Field Error: " + f.getDefaultMessage());
            }

            for (ObjectError e : bindingResult.getGlobalErrors()) {
                logger.info("Global Error: " + e.getDefaultMessage());
            }

            return "formValidationHome";
        }
        return "formValidationResult";
    }
}
