package code.elif.model.factory;

import code.elif.model.forXml.Organization;

public class OrganizationFactory {

    public Organization getInstance(String companyName,Integer yearOfIncorporation){
        return new Organization(companyName,yearOfIncorporation);
    }
}
