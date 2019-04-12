package com.akshatha.spring.repository.SignUp;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.akshatha.spring.dto.SignUp.SignUpDTO;
import com.akshatha.spring.entity.SignUp.SignUpEntity;

@Service
public interface SignUpRepository {

	public SignUpEntity signUpRep(SignUpEntity signUpEntity);
	public SignUpEntity checkEmailAdd(String userEmail);
	public SignUpEntity checkUserName(String userName);
	public SignUpEntity checkUserPhone(String userPhone);

}
