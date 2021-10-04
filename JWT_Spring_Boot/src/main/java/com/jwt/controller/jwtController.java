package com.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.config.CustomUserDetailService;
import com.jwt.helper.JwtTokenUtil;
import com.jwt.model.UserRequest;
import com.jwt.model.UserResponse;

@RestController
public class jwtController {
	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/token")
	public ResponseEntity<?> GenerateToken(@RequestBody UserRequest request) throws Exception{
		
		try {
			System.out.println(request);
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("Bad Credentials");
		}
		
		UserDetails loadUserByUsername = this.customUserDetailService.loadUserByUsername(request.getUserName());
		String token = this.jwtTokenUtil.generateToken(loadUserByUsername);
		System.out.println(token);
		return ResponseEntity.ok(new UserResponse(token));
		

		
		
	}

}
