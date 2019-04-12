package com.akshatha.spring.repository.securephrase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.akshatha.spring.dto.securephrase.SecurePhraseDTO;
import com.akshatha.spring.entity.SignUp.SignUpEntity;
import com.akshatha.spring.service.ChangePasswordServiceImpl;
@Repository
public class SecurePhraseRepositoryImpl implements SecurePhraseRepository {
	private final static Logger logger = LoggerFactory.getLogger(ChangePasswordServiceImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	public SecurePhraseRepositoryImpl() {
		logger.info("Created repo  : \t" +this.getClass().getSimpleName());
	}
	public SignUpEntity checkingSecurePhrase(SecurePhraseDTO dto) {
		try {
		Session session = null;
		session = sessionFactory.openSession();
		Query query = session.createNamedQuery("checkSecurePhrase");
		query.setParameter("username", dto.getUsername());
		SignUpEntity entityofSecure = (SignUpEntity) query.uniqueResult();
		
		return entityofSecure ;
		}catch(Exception e) {
			logger.info("Exception found : \t" +e.getMessage() );
		}
		return null;
	}

}
