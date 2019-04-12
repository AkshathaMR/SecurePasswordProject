package com.akshatha.spring.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.akshatha.spring.dto.SignUp.ChangePasswordDTO;
import com.akshatha.spring.entity.SignUp.SignUpEntity;

public interface ChangePasswordService
{
public HashMap<String, String> changePassword(ChangePasswordDTO dto);
public boolean findUserbyUserName(String name);

}
