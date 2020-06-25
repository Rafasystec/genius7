package com.genius7.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptHelper {
	
	private EncryptHelper() {
	}
	public static String cryptForDB(String pwd) {
		return new BCryptPasswordEncoder().encode(pwd);
	}

}
