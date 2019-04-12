package com.akshatha.spring.service;

import org.springframework.stereotype.Service;

import com.akshatha.spring.dto.SignUp.SignUpDTO;
import com.akshatha.spring.entity.SignUp.SignUpEntity;

public interface SignUpService {

	public SignUpEntity signUpService(SignUpDTO signUpdto);
}
