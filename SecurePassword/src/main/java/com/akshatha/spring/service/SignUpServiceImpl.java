package com.akshatha.spring.service;

import java.util.Collection;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akshatha.spring.dto.SignUp.SignUpDTO;
import com.akshatha.spring.email.MailSending;
import com.akshatha.spring.entity.SignUp.SignUpEntity;
import com.akshatha.spring.repository.SignUp.SignUpRepository;
import com.akshatha.spring.util.EncryptDecryptString;
import com.akshatha.spring.util.GeneratedPassword;

@Service
public class SignUpServiceImpl implements SignUpService {

	@Autowired
	private SignUpRepository signupRepository;

	@Autowired
	private GeneratedPassword generatedPassword;

	@Autowired
	private MailSending mailSending;

	@Autowired
	private EncryptDecryptString encryptdecryptString;

	private final static Logger logger = LoggerFactory.getLogger(SignUpServiceImpl.class);

	public SignUpEntity signUpService(SignUpDTO signUpdto) {
		logger.info("signUpService is invoked : \t");
		try {
			SignUpEntity signupEntity = new SignUpEntity();
			BeanUtils.copyProperties(signUpdto, signupEntity);
			logger.info("Copying from dto to entity");
			SignUpEntity emailfromDb = (SignUpEntity) signupRepository.checkEmailAdd(signupEntity.getUserEmail());
			SignUpEntity userNamefromDb = (SignUpEntity) signupRepository.checkUserName(signupEntity.getUserName());
			SignUpEntity userPhonefromDb = (SignUpEntity) signupRepository.checkUserPhone(signupEntity.getUserPhone());
			logger.info("checking uniqueness of details");

			if (emailfromDb == null && userNamefromDb == null && userPhonefromDb == null) {
				logger.info("enter the conditions");
				String password = generatedPassword.passwordGenerator();
				String encryptedData = EncryptDecryptString.encrypt(password);
				// signupEntity.setPassword(password);
				logger.info("Generating password for first time user \t" + password);
				// String encryptedData = encryptdecryptString.encrypt(password);
				// logger.info(encryptedData);
				signupEntity.setPassword(encryptedData);
				signupEntity.setFirstTime(false);
				signupEntity.setSecurePhrase(null);
				SignUpEntity datafromentity = signupRepository.signUpRep(signupEntity);

				if (datafromentity != null) {
					mailSending.sendingEmail(datafromentity);
					logger.info("Sending mail to user ");
					return datafromentity;
				}
				return datafromentity;
			} else {
				logger.info("Im inside else");

			}
		} catch (Exception e) {
			logger.error("Exception occured: \t" + e.getMessage());
		}
		return null;
	}

}
