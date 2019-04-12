package com.akshatha.spring.service.securephrase;

import java.util.HashMap;

import com.akshatha.spring.dto.securephrase.SecurePhraseDTO;

public interface SecurePhraseService {
public HashMap<String,String> CheckingSecurePhrase(SecurePhraseDTO dto);
}
