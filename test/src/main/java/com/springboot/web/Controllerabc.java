package com.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controllerabc {
@RequestMapping("/")
	public String handler() {
		return"home";
	}

@RequestMapping("/contact")
public String contact() {
	return"contact";
}

}
