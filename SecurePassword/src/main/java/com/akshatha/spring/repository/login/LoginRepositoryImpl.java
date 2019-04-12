package com.akshatha.spring.repository.login;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.akshatha.spring.dto.Login.LogInDTO;
import com.akshatha.spring.entity.SignUp.SignUpEntity;
import com.akshatha.spring.service.ChangePasswordServiceImpl;
@Repository
public class LoginRepositoryImpl implements LoginRepository {
	@Autowired
	private SessionFactory sessionFactory;
	
	private final static Logger logger = LoggerFactory.getLogger(LoginRepositoryImpl.class);

public SignUpEntity logIn(LogInDTO dto) {
		logger.debug("invoked login repository....");
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Query query =session.createNamedQuery("loginByUsername");
			query.setParameter("username", dto.getUsername());
			SignUpEntity userDataFromDb = (SignUpEntity) query.uniqueResult();
			return userDataFromDb;
		} catch (Exception e) {
		logger.error("Exception Found \t"+e.getMessage());
		}
		return null;
	}

}
