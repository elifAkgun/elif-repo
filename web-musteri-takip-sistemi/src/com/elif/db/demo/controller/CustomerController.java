package com.elif.db.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.elif.db.demo.entity.Customer;
import com.elif.db.demo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// need to inject customer service
	@Autowired
	private CustomerService customerService;

	@RequestMapping("/list")
	public String listCustomer(Model theModel) {

		// get the customer from dao

		List<Customer> customers = customerService.getCustomers();

		theModel.addAttribute("customerList", customers);

		// write customers

		return "list-customer";
	}

	@RequestMapping("/showFormForAdd")
	public String addCustomer(Model theModel) {

		Customer customer = new Customer();

		theModel.addAttribute("customer", customer);

		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {

		customerService.saveCustomer(customer);

		return "redirect:/customer/list";
	}

	@GetMapping("/showFormForUpdate")
	public String saveCustomer(@RequestParam("customerId") int customerId, Model theModel) {

		Customer customer = customerService.getCustomers(customerId);
		theModel.addAttribute("customer", customer);
		return "customer-form";
	}
	
	@GetMapping("/showFormForDelete")
	public String deleteCustomer(@RequestParam("customerId") int customerId, Model theModel) {

		customerService.deleteCustomer(customerId);
		
		return "redirect:/customer/list";
	} 
	
	
	
	
	@GetMapping("/search")
	public String searchCustomers(@RequestParam("theSearchName") String theSearchName, Model theModel) {

		 
		// search customers from the service
		List<Customer> theCustomers = customerService.searchCustomers(theSearchName);

		// add the customers to the model
		theModel.addAttribute("customerList", theCustomers);

		return "list-customer";
	}

}
