package com.elif.springdemo.student;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Value("#{countryOptions}") 
	private Map<String, String> countryOptions;
	
	@Value("#{languageOptions}") 
	private Map<String, String> languageOptions;
	
	@Value("#{operatingSystemOptions}") 
	private Map<String, String> operatingSystems;
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		
		model.addAttribute("student", new Student());
		
		// add the country options to the model 
	    model.addAttribute("theCountryOptions", countryOptions); 
	    model.addAttribute("theLanguageOptions", languageOptions); 
	    model.addAttribute("theOperatingSystems", operatingSystems); 
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student student) {
		return "student-confirmation"; 
	}
	
	

}
