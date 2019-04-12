package com.akshatha.spring.service.securephrase;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.akshatha.spring.dto.securephrase.SecurePhraseDTO;
import com.akshatha.spring.entity.SignUp.SignUpEntity;
import com.akshatha.spring.repository.securephrase.SecurePhraseRepository;
import com.akshatha.spring.util.EncryptDecryptString;
@Service
public class SecurePhraseServiceImpl implements SecurePhraseService {
@Autowired
private SecurePhraseRepository securePhraseReository;
@Autowired
private EncryptDecryptString encryptDecrypt ;
	public HashMap<String, String> CheckingSecurePhrase(SecurePhraseDTO dto) {
		
		HashMap<String,String> hashMap= new HashMap<String ,String>();
		
		if(!StringUtils.isEmpty(dto.getSecurePhrase())&&!StringUtils.isEmpty(dto.getUsername())) {
			SignUpEntity entitydatafromDb =securePhraseReository.checkingSecurePhrase(dto);
			if(entitydatafromDb != null) {
				String  PhraseDecryption= encryptDecrypt.decrypt(entitydatafromDb.getSecurePhrase());
			if(dto.getSecurePhrase().equals(PhraseDecryption)) {
				hashMap.put("datavalid","Valid user ...");
			}
			
			}
		}
		return hashMap;
	}

	

	
}
