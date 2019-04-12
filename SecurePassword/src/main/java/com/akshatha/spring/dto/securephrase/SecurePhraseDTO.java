package com.akshatha.spring.dto.securephrase;

public class SecurePhraseDTO {
private String securePhrase;
private String username;

public SecurePhraseDTO() {
	System.out.println("Created : \t"+this.getClass().getSimpleName());
}

public String getSecurePhrase() {
	return securePhrase;
}
public void setSecurePhrase(String securePhrase) {
	this.securePhrase = securePhrase;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
	
@Override
public String toString() {
	return "SecurePhraseDTO [securePhrase=" + securePhrase + ", username=" + username + "]";
}	
	
}
