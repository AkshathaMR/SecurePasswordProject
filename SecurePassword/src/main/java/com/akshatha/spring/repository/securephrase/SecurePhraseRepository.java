package com.akshatha.spring.repository.securephrase;

import com.akshatha.spring.dto.securephrase.SecurePhraseDTO;
import com.akshatha.spring.entity.SignUp.SignUpEntity;

public interface SecurePhraseRepository {
public  SignUpEntity checkingSecurePhrase(SecurePhraseDTO dto);
}
