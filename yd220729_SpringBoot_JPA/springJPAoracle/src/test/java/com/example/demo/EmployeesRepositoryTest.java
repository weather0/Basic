package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
//@DataJpaTest
public class EmployeesRepositoryTest {
	@Autowired
	EmployeesRepository repo;

	@Test
//	@Transactional
//	@Commit // 기본은 rollback. @Commit 달아주면 자동 커밋
	public void select() {
//		System.out.println(repo.findAll());
		System.out.println(repo.findByEmail("SKING"));
//		System.out.println(repo.findByDepartmentId(50));
	}
}
