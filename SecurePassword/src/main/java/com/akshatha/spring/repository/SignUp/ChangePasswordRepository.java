package com.akshatha.spring.repository.SignUp;

import org.springframework.stereotype.Service;

import com.akshatha.spring.dto.SignUp.ChangePasswordDTO;
import com.akshatha.spring.entity.SignUp.SignUpEntity;
@Service
public interface ChangePasswordRepository {
 public boolean savechangePassword(SignUpEntity entity);
 public  SignUpEntity fetchUserByUserName(ChangePasswordDTO dto);
 public SignUpEntity checkUserByUserName(String name);
 
}
