package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

//@SpringBootTest
@DataJpaTest
public class CustomerRepositoryTest {
	@Autowired
	CustomerRepository repo;

	// 생성자 대신 빌더로 생성
	@Test
	@Transactional
	@Commit // 기본은 rollback. @Commit 달아주면 자동 커밋
	public void insert() {
		Customer cust = Customer.builder()
								.id(1L)
								.name("")
								.phone("011")
								.build();
		repo.save(cust);
	}
}
