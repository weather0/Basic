package com.company.app.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.company.app.sample.service.SampleService;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/*-context.xml")
@Log4j // ->변수명은 log로 자동생성됨
public class SampleServiceTest {

	@Autowired // = @Setter(onMethod_ = @Autowired)
	SampleService service;
	
	@Test
//	@Transactional // 이거 붙이면 tbl_sample1,2 둘 다 insert 안 됨. 안 붙이면 varchar2크기에 따라 tbl_sample1만 입력됨.
	public void test() {
		service.addData("테스트3333!");
	}
}
