package code.elif.controller;

import code.elif.model.Organization;
import code.elif.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class OrganizationController {

    private OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @RequestMapping("organization-list")
    public String listOrganizations(Model model){
        List<Organization> allOrganisations = organizationService.getAllOrganisations();
        model.addAttribute("allOrganisations",allOrganisations);
        return "organization-list";
    }

    @RequestMapping(value = "jndi-example")
    public String organisationJNDI(){
        return "jndi-example";
    }
}
