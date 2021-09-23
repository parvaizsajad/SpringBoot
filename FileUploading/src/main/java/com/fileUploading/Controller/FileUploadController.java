package com.fileUploading.Controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fileUploading.Helper.Helper;

@RestController
public class FileUploadController {
	@Autowired
	private Helper helper;
	
	@PostMapping("/upload")
	public ResponseEntity<String> uploadfile(@RequestParam("file") MultipartFile file) throws IOException{
		System.out.println(file.getName());
		System.out.println(file.getOriginalFilename());
		System.out.println(new ClassPathResource("static"+File.separator+"images").getFile().getAbsolutePath());
		System.out.println(ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(file.getOriginalFilename()).toString()));
		
		try {
			if(file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("request must contain file");
			}
			
			if(!file.getContentType().equals("image/jpeg")) {
				
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("only jpeg images are allowed");
			}
			// file upload code.
boolean fileupload = helper.fileupload(file);
			if(fileupload) {
			//	return ResponseEntity.ok("file is uploaded successfully");
				return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(file.getOriginalFilename()).toUriString());
			}
			
			
		} catch (Exception e) {
		e.printStackTrace();
		}

		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong");
		
		
	}
}
