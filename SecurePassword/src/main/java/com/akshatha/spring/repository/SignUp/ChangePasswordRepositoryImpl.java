package com.akshatha.spring.repository.SignUp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.akshatha.spring.dto.SignUp.ChangePasswordDTO;
import com.akshatha.spring.entity.SignUp.SignUpEntity;
import com.akshatha.spring.service.ChangePasswordServiceImpl;

@Repository
public class ChangePasswordRepositoryImpl implements ChangePasswordRepository {
	private final static Logger logger = LoggerFactory.getLogger(ChangePasswordServiceImpl.class);

	@Autowired
	private SessionFactory factory;

	public boolean savechangePassword(SignUpEntity entity) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			session.update(entity);
			transaction.commit();
			logger.info("Password Updated successfully");
			return true;
		} catch (Exception e) {
			transaction.rollback();
			logger.error(e.getMessage());
			return false;

		}

	}

	public SignUpEntity fetchUserByUserName(ChangePasswordDTO dto) {
Session session = null;
try {
	session= factory.openSession();
 Query query  =session.getNamedQuery("fetchUserByName");
 query.setParameter("hosauserName", dto.getUserName());
 SignUpEntity checkingPassword = (SignUpEntity) query.uniqueResult();
 logger.info("checking password : \t"+checkingPassword);
 return checkingPassword;
} catch (Exception e) {
	logger.error("Exception found : \t" +e.getMessage());
	return null;
}
		
	}

	/*public SignUpEntity checkUserById(int id) {
		Session session =null;
		 try {
			session = factory.openSession();
			Query query = session.getNamedQuery("checkUserByUserName");
			query.setParameter("Id",id);
			SignUpEntity dataFromDB = (SignUpEntity) query.uniqueResult();
			logger.info("Fetching data from DB \t"+dataFromDB);
			return dataFromDB;
			
		} catch (Exception e) {
			logger.error("Exception found : \t"+e.getMessage());
		}

		return null;
	}*/

	public SignUpEntity checkUserByUserName(String name) {
		Session session =null;
		 try {
			session = factory.openSession();
			Query query = session.getNamedQuery("checkUserByUserName");
			query.setParameter("userName",name);
			SignUpEntity dataFromDB = (SignUpEntity) query.uniqueResult();
			logger.info("Fetching data from DB \t"+dataFromDB);
			return dataFromDB;
			
		} catch (Exception e) {
			logger.error("Exception found : \t"+e.getMessage());
		}

		return null;
	}

}
