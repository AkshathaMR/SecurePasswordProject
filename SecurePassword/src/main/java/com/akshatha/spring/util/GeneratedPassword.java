package com.akshatha.spring.util;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.akshatha.spring.controller.SignUp.SignUPController;
@Component
public class GeneratedPassword {
	private final static Logger logger = LoggerFactory.getLogger(SignUPController.class);

	public String passwordGenerator() {
		logger.info("passwordGenerator invoked....");
		int length = 8;
		logger.info("password generated using random() method.....");

		String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String Small_chars = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String symbols = "!@#$%^&*_=+-/.?<>)";

		String values = Capital_chars + Small_chars + numbers + symbols;
		String passwordReturned = "";
		// Using random method
		Random rndm_method = new Random();

		char[] password = new char[length];

		for (int i = 0; i < length; i++) {
			// Use of charAt() method : to get character value
			// Use of nextInt() as it is scanning the value as int
			password[i] = values.charAt(rndm_method.nextInt(values.length()));
			
		}
String passwordgenerated = new String(password);
		return passwordgenerated;

	}

}
