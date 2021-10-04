package com.jwt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private CustomUserDetailService customUserDetailService;
	@Autowired
	private jwtAuthenticationFilter authenticationFilter;
	@Autowired
	private jwtAuthenticationEntrypoint entrypoint;

@Override
	protected void configure(HttpSecurity http) throws Exception {
http
.csrf()
.disable()
.cors()
.disable()
.authorizeRequests()
.antMatchers("/token").permitAll()
.anyRequest()
.authenticated()
.and()
.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
.exceptionHandling().authenticationEntryPoint(entrypoint);

http.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);
	}
@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.userDetailsService(customUserDetailService);
	}
@Bean
public PasswordEncoder encoder() {
	return NoOpPasswordEncoder.getInstance();
}
@Bean
public AuthenticationManager authenticationManagerBean() throws Exception {
	return super.authenticationManagerBean();
}
}
