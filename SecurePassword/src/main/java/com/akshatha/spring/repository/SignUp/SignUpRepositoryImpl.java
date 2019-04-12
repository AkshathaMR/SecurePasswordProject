package com.akshatha.spring.repository.SignUp;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.akshatha.spring.dto.SignUp.SignUpDTO;
import com.akshatha.spring.entity.SignUp.SignUpEntity;

@Repository
public class SignUpRepositoryImpl implements SignUpRepository {

	
	private final static Logger logger = LoggerFactory.getLogger(SignUpRepositoryImpl.class);

	public SignUpRepositoryImpl() {
		logger.info("Created : \t" + this.getClass().getSimpleName());
	}

	@Autowired
	private SessionFactory sessionFactory;

	public SignUpEntity signUpRep(SignUpEntity signUpEntity) {
		logger.info("Signupsave method invoked \t");
		Session session = null;
		try {
			logger.info("invoking signUp in repo" + signUpEntity);
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(signUpEntity);
			transaction.commit();
			logger.info("User data Saved Successfully: \t" + signUpEntity);
			return signUpEntity;

		} catch (Exception e) {
			session.getTransaction().rollback();
			logger.error("Exception occured in saving entity : \t" + e.getMessage());
			//e.printStackTrace();
		} finally {
			session.close();
		}
		return signUpEntity;
	}

	public SignUpEntity checkEmailAdd(String emailAdd) {
		Session session = null;
		try {
			logger.info("invoking checkmail in repo" + emailAdd);
			session = sessionFactory.openSession();
			Query query = session.getNamedQuery("fetchBymailAdd");
			query.setParameter("userEmail", emailAdd);
			SignUpEntity emailfromDb = (SignUpEntity) query.uniqueResult();
			logger.info("data  from db by useremail \t " + emailfromDb);
			return emailfromDb;
		} catch (Exception e) {
			logger.info("Exception occured : \t" + e.getMessage());
		} finally {
			session.close();
		}
		return null;

	}

	public SignUpEntity checkUserName(String userName) {
		Session session = null;
		try {
			logger.info("invoking checkname in repo" + userName);
			session = sessionFactory.openSession();
			Query query = session.getNamedQuery("fetchByuserName");
			query.setParameter("userName", userName);
			SignUpEntity namefromDb = (SignUpEntity) query.uniqueResult();
			logger.info("data from db by username\t" + namefromDb);
			return namefromDb;
		} catch (Exception e) {
			logger.error("Exception occured : \t" + e.getMessage());
		}
		return null;
	}

	public SignUpEntity checkUserPhone(String userPhone) {
		Session session = null;
		try {
			logger.info("invoking checkuserPhone in repo\t" + userPhone);
			session = sessionFactory.openSession();
			Query query = session.getNamedQuery("fetchByuserPhone");
			query.setParameter("userPhone", userPhone);
			SignUpEntity phoneformDb = (SignUpEntity) query.uniqueResult();
			logger.info("data from db  userPhone " + phoneformDb);
			return phoneformDb;
		} catch (Exception e) {
			logger.error("Exception occured : \t" + e.getMessage());
		} finally {
			session.close();
		}

		return null;
	}

}
