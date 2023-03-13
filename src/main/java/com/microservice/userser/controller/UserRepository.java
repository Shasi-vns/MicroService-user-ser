package com.microservice.userser.controller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends JpaRepository<User, Integer>{

	 @Query("SELECT u FROM User u WHERE u.username = :username")
	    User getUserByUsername(@Param("username") String username);
	 
	 @Query("SELECT u FROM User u WHERE u.mobile = :username")
	 User getUserByMobile(@Param("username") String username);
	 
	 @Query(value="SELECT * FROM User u WHERE u.mobile = :keyword",nativeQuery=true)
	 List<User> findByMobile(@Param("keyword") String keyword);
	 
	 @Query("SELECT COUNT(*) FROM User u WHERE u.role = 'USER'")
	 Integer getnoofusers();
	 
	 @Query("SELECT COUNT(*) FROM User u WHERE u.role = 'ADMIN'")
	 Integer getnoofadmins();
	 
	 
	 @Query("SELECT COUNT(*) FROM User u WHERE u.role = 'CREATER'")
	 Integer getnoofcreaters();
}

