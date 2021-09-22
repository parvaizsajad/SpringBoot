package com.thymeleaf.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ThymeleafController {
	@RequestMapping(value="/about",method = RequestMethod.GET)
	public String show(Model m) {
		System.out.println("running about handler");
		m.addAttribute("name","Parvaiz Sajad");
		m.addAttribute("date",new Date().toGMTString());
		m.addAttribute("baabji", "marilyn sultana talukdar");
		return "about";
	}
	
	// this is for controlling the iteration in the thymeleaf.
	@RequestMapping(value = "/iterate",method = RequestMethod.GET)
	public String ThCont(Model m) {
		
		List<String> nameList = List.of("karan","jhon","smith","jacob");
		m.addAttribute("nameList", nameList);
		return"iterate";
	}

	// This is a conditional controller
	@GetMapping("/conditional")
	public String condhandler(Model m) {
		m.addAttribute("isActive", false);
		m.addAttribute("Gender", "F");
		List<Integer> numLi = List.of(111);
		m.addAttribute("numli", numLi);
		
		return"conditional";
	}
	
	
	// Handler fot the fragments
	@GetMapping("/fragment")
	public String fragmenthandler(Model m) {
		m.addAttribute("title","this is the controller title");
		m.addAttribute("date", LocalDate.now().toString());
		
		return "fragment";
	}
	
	// Handler fot the service
		@GetMapping("/service")
		public String service(Model m) {
			m.addAttribute("title","this is the controller title");
			m.addAttribute("date", LocalDate.now().toString());
			
			return "service";
		}
		
		// Handler fot the contact
		@GetMapping("/contact")
		public String contact(Model m) {
			m.addAttribute("title","this is the controller title");
			m.addAttribute("date", LocalDate.now().toString());
			
			return "contact";
		}
}
