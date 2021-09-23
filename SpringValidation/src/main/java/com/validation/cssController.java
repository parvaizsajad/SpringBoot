package com.validation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class cssController {
	
	@RequestMapping("/attachment")
	public String AttachmentController() {
		
		
		System.out.println("css controller is running");
		
		return"srevices";
	}

}
