package com.fileUploading.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CssController {
	@RequestMapping("/services")
	public String cssController() {
		System.out.println("css controller");
		return "service";
	}

}
