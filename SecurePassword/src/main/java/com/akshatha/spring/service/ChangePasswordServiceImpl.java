package com.akshatha.spring.service;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.akshatha.spring.constants.AppConstants;
import com.akshatha.spring.controller.SignUp.SignUPController;
import com.akshatha.spring.dto.SignUp.ChangePasswordDTO;
import com.akshatha.spring.entity.SignUp.SignUpEntity;
import com.akshatha.spring.repository.SignUp.ChangePasswordRepository;
import com.akshatha.spring.util.EncryptDecryptString;

@Service
public class ChangePasswordServiceImpl implements ChangePasswordService {
	@Autowired
	private ChangePasswordRepository changePasswordRepository;
	@Autowired
	private EncryptDecryptString encryptDecrypt;
	private final static Logger logger = LoggerFactory.getLogger(ChangePasswordServiceImpl.class);

	public HashMap<String, String> changePassword(ChangePasswordDTO dto) {

		logger.info("ChangePassword is invoked \t" + dto);
		System.out.println("Came to changepassword method serviceIMPL");
		SignUpEntity dataFromDb = new SignUpEntity();
		HashMap<String, String> map = new HashMap<String, String>();
		if (!StringUtils.isEmpty(dto.getUserName()) && !StringUtils.isEmpty(dto.getOldPassword())
				&& !StringUtils.isEmpty(dto.getNewPassword()) && !StringUtils.isEmpty(dto.getConfirmPassword())
				&& !StringUtils.isEmpty(dto.getSecurePhrase())) {
			if (dto.getNewPassword().equals(dto.getConfirmPassword())) {
				boolean validation = passwordValidation(dto);
				logger.info("password validating \t" + validation);
				if (validation) {
					dataFromDb = changePasswordRepository.fetchUserByUserName(dto);
					logger.info("Old password is \t" + dataFromDb.getPassword());
					logger.info("user id FirsttimeLogin \t" + dataFromDb.isFirstTime());

					String oldPassword = dto.getOldPassword();
					logger.info("OldPassword is \t" + oldPassword);
					String passWordDecryption = encryptDecrypt.decrypt(dataFromDb.getPassword());
					System.out.println(passWordDecryption);
					if (oldPassword.equals(passWordDecryption)) {
						dataFromDb.setFirstTime(true);
						dataFromDb.setPassword(encryptDecrypt.encrypt(dto.getNewPassword()));
						dataFromDb.setSecurePhrase(encryptDecrypt.encrypt(dto.getSecurePhrase()));
						boolean dataUpdatetoDb = changePasswordRepository.savechangePassword(dataFromDb);
						if (dataUpdatetoDb) {
							map.put("passWordUpdated", "Password Updated Successfully");
							return map;
						}
					} else {
						map.put("wrongPassWord", "Hey sorry ! ,You have Entered a WrongPassword...");
					}
				} else {
					map.put("AlreadyUpdated", "You have Already Updated Your Password...");
					return map;
				}
			} else {
				map.put("userNull", "user should not be null... Please"
						+ " fill the user field");
			}
		} else {
			map.put("passWordLen",
					"Password Length should be 8 ,it must contains one UpperCase ,LowerCase,and One Number");
			return map;
		}
		return map;
	}

	/*
	 * public boolean findUserbyId(int id) {
	 * logger.info("invoking the findUserbyName \t"+id); SignUpEntity userFromEntity
	 * = changePasswordRepository.checkUserById(id); if(userFromEntity !=null) {
	 * logger.info("UserName is Present : \t" +userFromEntity); return true; } else
	 * { return false; } }
	 */

	public static boolean passwordValidation(ChangePasswordDTO dto) {
		logger.info("invoked passwordValidation ");
		Pattern pattern = Pattern.compile(AppConstants.PASSWORD_PATTERN);
		Matcher matcher = pattern.matcher(dto.getNewPassword());
		if (matcher.matches()) {
			return true;
		} else {
			return false;
		}

	}

	public boolean findUserbyUserName(String name) {
		logger.info("invoking the findUserbyName \t" + name);
		SignUpEntity userFromEntity = changePasswordRepository.checkUserByUserName(name);
		if (userFromEntity != null) {
			logger.info("UserName is Present : \t" + userFromEntity);
			return true;
		} else {
			return false;
		}
	}

}
