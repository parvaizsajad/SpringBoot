package com.springboot.web;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.springboot.web.Entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	
	//hql querry.
	@Query("select u FROM User u")
public List<User> getAllUser();

	@Query("select u FROM User u WHERE u.name =:n")
	public List<User> getUserByName(@Param("n") String name);
	
	// native qurrey   normal sql qurrey
	@Query(value = "select * FROM User",nativeQuery = true)
public List<User> getAllUserN();
}
