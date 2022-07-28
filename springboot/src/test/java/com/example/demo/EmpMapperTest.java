package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpMapperTest {
	@Autowired
	EmpMapper mapper;

	@Test
	void list() {
		System.out.println(mapper.getEmpList());
	}
}
