package com.elif.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

	// need a controller method to show the initial HTML form
	//demo changes...
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
		
	// need a controller method to process the HTML form
		
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
		
	@RequestMapping("/processFormVersionTwo")
	public String processForm2(HttpServletRequest request, Model model) {
		
		String theName = request.getParameter("studentName");
		
		theName = theName.toUpperCase();
		
		String message = theName + " WHAT'S UP!";
		
		model.addAttribute("message", message);
		
		return "helloworld";
	}
	@RequestMapping("/processFormVersionThree")
	
	public String processForm3(@RequestParam("studentName")String theName, Model model) {
		
		theName = theName.toUpperCase();
		
		String message = theName + " WHAT'S UP dude!";
		
		model.addAttribute("message", message);
		
		return "helloworld";
	}
		
}