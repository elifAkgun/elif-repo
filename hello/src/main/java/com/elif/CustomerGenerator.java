package com.elif;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TimeZone;

import com.elif.entity.Address;
import com.elif.entity.Bank;
import com.elif.entity.Customer;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomerGenerator {

	public static void main(String[] args) {
		Customer customer = new Customer();

		customer.setActivateDate(LocalDate.now());

		Address address = new Address();

		address.setCity("Istanbul");
		address.setCountry("Turkey");
		address.setStreet("Ataturk sok.");
		address.setZipCode("1234");

		customer.setAddress(address);

		Set<Bank> banks = new HashSet<Bank>();

		Bank bank1 = new Bank();
		bank1.setName("Mir Bank");
		banks.add(bank1);

		Bank bank2 = new Bank();
		bank2.setName("Parrot Bank");
		banks.add(bank2);

		customer.setBanks(banks);

		customer.setName("Elif");

		customer.setSurname("Akgun");

		customer.setPhoneNumbers(Arrays.asList("123456789", "11111111"));

		// Creating Object of ObjectMapper define in jackson Api
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setTimeZone(TimeZone.getDefault());
		mapper.setDateFormat(dateFormat);
		try {

			// get Oraganisation object as a json string
			String jsonStr = mapper.writeValueAsString(customer);

			// Displaying JSON String
			System.out.println(jsonStr);
		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
