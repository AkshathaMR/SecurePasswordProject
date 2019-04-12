package com.akshatha.spring.service.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akshatha.spring.dto.Login.LogInDTO;
import com.akshatha.spring.entity.SignUp.SignUpEntity;
import com.akshatha.spring.repository.login.LoginRepository;
import com.akshatha.spring.repository.login.LoginRepositoryImpl;
import com.akshatha.spring.repository.login.LoginRepository;
import com.akshatha.spring.util.EncryptDecryptString;

@Service
public class LoginServiceImpl implements LoginService {

	private final static Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	@Autowired
	private LoginRepository loginRepository;
	@Autowired
	private EncryptDecryptString encryptDecrypt;
	
	public boolean logIn(LogInDTO dto) {
		logger.debug("Invoked ServiceImpl");
		System.out.println("Coming login service...");
		SignUpEntity userFromDb = loginRepository.logIn(dto);
		if (userFromDb != null) {
			String decryptedPassword = encryptDecrypt.decrypt(userFromDb.getPassword());
			System.out.println(decryptedPassword);
			if (decryptedPassword.equals(dto.getPassword())) {
				logger.info("User Successfully logged in ");
				return true;
			} else {
				return false;
			}
		}
		return false;
	}


	

}
