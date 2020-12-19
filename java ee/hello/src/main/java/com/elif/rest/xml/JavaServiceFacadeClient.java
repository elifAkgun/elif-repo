package com.elif.rest.xml;

import java.util.List;

public class JavaServiceFacadeClient {
    public static void main(String[] args) {
        try {
            final JavaServiceFacade javaServiceFacade = new JavaServiceFacade();
            for (Countries countries : (List<Countries>) javaServiceFacade.getCountriesFindAll()) {
                printCountries(countries);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void printCountries(Countries countries) {
        System.out.println("countryId = " + countries.getCountryId());
        System.out.println("countryName = " + countries.getCountryName());
        System.out.println("regionId = " + countries.getRegionId());
    }
}
