package com.springboot.web;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ConfigurableApplicationContext;

import com.springboot.web.Entities.User;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext context =SpringApplication.run(TestApplication.class, args);
	UserRepository ur = context.getBean(UserRepository.class);
	/*
	 * User us=new User(); us.setName("parvaiz sajad");
	 * us.setCity("bangalore karnataka");
	 * us.setStatus("i am learning java language");
	 * 
	 * User us1=new User(); us1.setName("parvaiz sajad mir");
	 * us1.setCity("bangalore karnataka indai");
	 * us1.setStatus("i am learning java language and spring");
	 * 
	 * List<User> liu=List.of(us,us1);
	 * 
	 * Iterable<User> saveAll = ur.saveAll(liu);
	 * saveAll.forEach(user->System.out.println(user));
	 */
	
	
	/**code to update
    Optional<User> findById = ur.findById(2);
    User us = findById.get();
    us.setName("parvaiz sajad");
	  us.setCity("kashmir");
	  User save = ur.save(us);
	  System.out.println(us);**/
/**
	//code to get the data
	Iterable<User> findAll = ur.findAll();
	findAll.forEach(System.out::println);
	**/
	/**
	// code for delete/
	ur.deleteById(2);
	
	**/
	//List<User> userByName = ur.getAllUser();
	//userByName.forEach(System.out::println);
	
	List<User> userByName = ur.getUserByName("parvaiz");
	userByName.forEach(System.out::println);
	System.out.println("--------------------------------------------");
	

	List<User> ByName = ur.getAllUserN();
	ByName.forEach(System.out::println);
	}

}
