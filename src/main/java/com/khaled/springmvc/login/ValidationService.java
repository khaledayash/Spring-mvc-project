package com.khaled.springmvc.login;

import org.springframework.stereotype.Service;

@Service
public class ValidationService {
	
	
public boolean isValid(String name, String password) {
	if(name.toLowerCase().equals("khaled") && password.equals("AYASH")) return true;
	
	return false;
	
}
}
