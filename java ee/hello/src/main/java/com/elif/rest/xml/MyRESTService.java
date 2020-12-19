package com.elif.rest.xml;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("services")
public class MyRESTService {
    public MyRESTService() {
        super();
    }

    @GET
    @Produces(value = { "application/json;qs=0.9", "application/xml;qs=0.8" })
    @Path("/")
    public List<Countries> getAllCountries() {

        List<Countries> countries = new ArrayList<Countries>();

        try {
            final JavaServiceFacade javaServiceFacade = new JavaServiceFacade();
            List<Countries> allCountries = javaServiceFacade.getCountriesFindAll();

            for (Countries country : allCountries) {
                Countries newCountry = new Countries();
                newCountry.setCountryId(country.getCountryId());
                newCountry.setCountryName(country.getCountryName());
                newCountry.setRegionId(country.getRegionId());
                countries.add(newCountry);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return countries;
    }
    
}
