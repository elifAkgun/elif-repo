package code.elif.controller;

import code.elif.model.OrganizationRegistration;
import code.elif.service.OrganizationRegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/formTagsDemo")
public class FormTagController {

    public final OrganizationRegistrationService organizationRegistrationService;

    public FormTagController(OrganizationRegistrationService organizationRegistrationService) {
        this.organizationRegistrationService = organizationRegistrationService;
    }

    @ModelAttribute
    public void modelMap(Model model){
        Map<String, Object> modelMap = model.asMap();
        modelMap.put("organizationResources",organizationRegistrationService.organizationResources());
        modelMap.put("organizationEmployeeResources",organizationRegistrationService.organizationEmployeeResources());
        modelMap.put("organizationBenefitResources",organizationRegistrationService.organizationBenefitResources());
        modelMap.put("yesNoResources",organizationRegistrationService.yesNoResources());
        modelMap.put("subscriptionList",organizationRegistrationService.subscriptionServicesResources());
        modelMap.put("paymentType", organizationRegistrationService.payBillOptionsResources());
    }

    @RequestMapping("/home")
    public ModelAndView home(Model model){
        return new ModelAndView("orgRegister", "orgRegistration",new OrganizationRegistration());
    }

    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public String orgRegisterResult(@ModelAttribute OrganizationRegistration orgRegistration, Model model){
        model.addAttribute("orgRegistration",orgRegistration);
        return "orgResult";
    }

}
