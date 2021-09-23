package com.validation.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.validation.entities.LoginData;

@Controller
public class ControllerHandler {
	@GetMapping("/form")
	public String OpenForm(Model m) {
		System.out.println("opening form");
		m.addAttribute("logindata", new LoginData());
		m.addAttribute("name", "parvaiz");
		return "form";
	}

	@PostMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("logindata") LoginData logindata, BindingResult result) {
		System.out.println(logindata);
		if(result.hasErrors()) {
			System.out.println(result);
			return "form";
		}
		
		return "success";
	}
}
