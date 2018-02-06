package com.springboot.web.service;

import org.springframework.stereotype.Service;
@Service
public class LoginService {
		
	public boolean isValidUser(String userid,String password) {
		return userid.equalsIgnoreCase("jaisudha") && password.equalsIgnoreCase("jai123");
		
	}

	
	
}
