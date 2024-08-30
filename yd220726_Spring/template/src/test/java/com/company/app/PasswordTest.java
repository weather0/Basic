package com.company.app;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordTest {
	@Test
	public void test() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
		String result = encoder.encode("1111");
		System.out.println(result);
		assertTrue(encoder.matches("1112", result)); // 불일치 로그 확인
	}
}
