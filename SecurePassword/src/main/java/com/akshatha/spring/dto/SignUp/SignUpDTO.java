package com.akshatha.spring.dto.SignUp;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SignUpDTO implements Serializable {

	private int id;

	private String userEmail;

	private String userPhone;

	private String userName;

	private String type;

	private boolean isFirstTime;

	private String password;
	private final static Logger logger = LoggerFactory.getLogger(SignUpDTO.class);

	public SignUpDTO() {
		logger.debug("Created  DTO : \t" + this.getClass().getSimpleName());
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isFirstTime() {
		return isFirstTime;
	}

	public void setFirstTime(boolean isFirstTime) {
		this.isFirstTime = isFirstTime;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "SignUpDTO [userEmail=" + userEmail + ", userPhone=" + userPhone + ", userName=" + userName + ", type="
				+ type + ", isFirstTime=" + isFirstTime + ", password=" + password + "]";
	}

}
