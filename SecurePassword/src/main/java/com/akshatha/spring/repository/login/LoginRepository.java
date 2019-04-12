package com.akshatha.spring.repository.login;

import com.akshatha.spring.dto.Login.LogInDTO;
import com.akshatha.spring.entity.SignUp.SignUpEntity;

public interface LoginRepository {
public SignUpEntity logIn(LogInDTO dto) ;
}
