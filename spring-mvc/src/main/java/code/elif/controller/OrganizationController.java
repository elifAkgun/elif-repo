package code.elif.controller;

import code.elif.model.Organization;
import code.elif.service.OrganizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class OrganizationController {

    private OrganizationService organizationService;

    private static Logger logger = LoggerFactory.getLogger("Organization Logger");

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @RequestMapping("organization-list")
    public String listOrganizations(Model model){
        logger.debug("organization-list controller is called");
        List<Organization> allOrganisations = organizationService.getAllOrganisations();
        model.addAttribute("allOrganisations",allOrganisations);
        logger.info("organization-list view is returning");
        return "organization-list";
    }

    @RequestMapping(value = "jndi-example")
    public String organisationJNDI(){
        logger.debug("jndi-example controller is called");
        logger.info("jndi-example view is returning");
        return "jndi-example";
    }
}
