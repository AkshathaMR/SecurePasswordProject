package com.akshatha.spring.dto.Login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.akshatha.spring.controller.SignUp.SignUPController;

public class LogInDTO {
	
 private String username;
 private String password;

 private final static Logger logger = LoggerFactory.getLogger(SignUPController.class);
 public LogInDTO() {
	 System.out.println("Created Login dto : \t" +this.getClass().getSimpleName());
 }

 @Override
public String toString() {
	return "LogInDTO [username=" + username + ", password=" + password + "]";
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}


}
