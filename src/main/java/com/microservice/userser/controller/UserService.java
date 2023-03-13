package com.microservice.userser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	
	@Autowired
	private UserRepository up;
	
	public Integer verifyuser(String uname) {
		User user = up.getUserByUsername(uname);
		if (user == null) {
			return 0;
		}
		else {
			return user.getId();
		}
		
	}

}
