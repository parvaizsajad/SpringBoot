package com.jwt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {
	@RequestMapping("/welcome")
	public String Welcom() {
		
		String text="hello this is a str test";
				
				text+="  this is not allowed for the un authenticated users";
				return text;
	}

	@RequestMapping("/hello")
	public String hello() {
		
		String text="this is a hello text";
		return text;
	}
}
