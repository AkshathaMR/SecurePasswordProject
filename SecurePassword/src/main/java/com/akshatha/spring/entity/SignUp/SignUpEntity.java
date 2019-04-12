package com.akshatha.spring.entity.SignUp;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "signup_table")
@NamedQueries({ @NamedQuery(name = "fetchBymailAdd", query = "from SignUpEntity where userEmail=:userEmail"),
		@NamedQuery(name = "fetchByuserName", query = "from SignUpEntity where userName=:userName"),
		@NamedQuery(name = "fetchByuserPhone", query = "from SignUpEntity where userPhone=:userPhone") ,
@NamedQuery(name="checkUserByUserName",query="from SignUpEntity where userName=:userName"),
@NamedQuery(name="fetchUserByName",query="from SignUpEntity where userName= :hosauserName"),
@NamedQuery(name="loginByUsername",query="from SignUpEntity where userName=:username"),
@NamedQuery(name="checkSecurePhrase",query="from SignUpEntity where userName=:username")
})

public class SignUpEntity implements Serializable {
	@Id
	@GenericGenerator(name="qqq" ,strategy="increment")
	@GeneratedValue(generator="qqq")
	@Column(name="id")
	private int id;
	
	@Column(name = "user_email")
	private String userEmail;
	@Column(name = "user_phone")
	private String userPhone;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "user_type")
	private String type;
	@Column(name = "user_isFirsttime")
	private boolean isFirstTime;
	@Column(name = "user_password")
	private String password;
	@Column(name="secure_phrase")
	private String securePhrase;
	
	public String getSecurePhrase() {
		return securePhrase;
	}

	public void setSecurePhrase(String securePhrase) {
		this.securePhrase = securePhrase;
	}

	private final static Logger logger = LoggerFactory.getLogger(SignUpEntity.class);

	public SignUpEntity() {
		logger.info("Created Entity : \t" + this.getClass().getSimpleName());
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
