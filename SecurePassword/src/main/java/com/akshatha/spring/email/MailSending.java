package com.akshatha.spring.email;


import org.springframework.stereotype.Service;

import com.akshatha.spring.entity.SignUp.SignUpEntity;

public interface MailSending {
public void sendingEmail(SignUpEntity datafromentity);
}
