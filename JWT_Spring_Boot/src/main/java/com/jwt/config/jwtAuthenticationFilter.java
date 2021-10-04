package com.jwt.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.jwt.helper.JwtTokenUtil;



@Component
public class jwtAuthenticationFilter extends OncePerRequestFilter{
	
	@Autowired
	private JwtTokenUtil tokenUtil;
	@Autowired
	private CustomUserDetailService customUserDetailService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String rtheader = request.getHeader("Authorization");
		String userName=null;
		String jwttoken=null;
		if(rtheader!=null && rtheader.startsWith("Bearer")){
			jwttoken=rtheader.substring(7);
			try {
				userName = this.tokenUtil.getUsernameFromToken(jwttoken);
				
			} catch (Exception e) {
				// TODO: handle exception
				e.getMessage();
				
				
			}
			
			UserDetails userDetails = this.customUserDetailService.loadUserByUsername(userName);
			if(userName!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
				
				UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());
				authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			}else {
				System.out.println("token is not validated");
			}
			
		}filterChain.doFilter(request, response);
		
	}

}
