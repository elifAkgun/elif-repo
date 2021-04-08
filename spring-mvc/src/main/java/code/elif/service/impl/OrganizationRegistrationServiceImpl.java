package code.elif.service.impl;

import code.elif.service.OrganizationRegistrationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

@Service
public class OrganizationRegistrationServiceImpl implements OrganizationRegistrationService {

    @Value("#{orgProperties}")
    private Map<String, String> orgProperties;

    @Override
    public Map<String, String> organizationResources() {
        return new TreeMap<>(orgProperties);
    }

    @Override
    public Map<String, String> organizationEmployeeResources() {
        Map<String, String> map = new TreeMap<>();
        map.put("1", "Only 1 Person");
        map.put("10", "Lower than 10");
        map.put("50", "Lower than 50");
        map.put("100", "Lower than 100");
        map.put("101", "Upper than 100");
        return map;
    }

    @Override
    public Map<String, String> organizationBenefitResources() {
        Map<String, String> map = new TreeMap<>();
        map.put("1", "Lunch Support");
        map.put("2", "Social Benefits");
        map.put("3", "Personal Education Program");
        map.put("4", "Coffee and Tea");
        return map;
    }

    @Override
    public Map<String, String> yesNoResources() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("true", "Yes");
        map.put("false", "No");
        return map;
    }

    @Override
    public Map<String, String> subscriptionServicesResources() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("emailServices", "Mailing List");
        map.put("letterService", "Weekly Letter");
        map.put("promotionalService", "Promotional Information");
        return map;
    }

    @Override
    public Map<String, String> payBillOptionsResources() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("creditCard", "Credit Card");
        map.put("moneyTransfer", "Money Transfer");
        map.put("onlinePayment", "Online Payment");
        return map;
    }
}
