package code.elif.service;

import java.util.Map;
import java.util.TreeMap;

public interface OrganizationRegistrationService {

    Map<String, String> organizationResources();

    Map<String, String> organizationEmployeeResources();

    Map<String, String> organizationBenefitResources();

    Map<String, String> yesNoResources();

    Map<String, String> subscriptionServicesResources();

    Map<String, String> payBillOptionsResources();
}
