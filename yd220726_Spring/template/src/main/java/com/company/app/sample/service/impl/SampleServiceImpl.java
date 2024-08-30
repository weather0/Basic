package com.company.app.sample.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.app.sample.mapper.Sample1Mapper;
import com.company.app.sample.service.SampleService;
@Service // 이거 꼭 붙여주자!! 안붙이면 오류남: Error creating bean with name ~: Unsatisfied dependency expressed through field 'service'; 
public class SampleServiceImpl implements SampleService {

	@Autowired Sample1Mapper s1;
	@Autowired Sample1Mapper s2;
	
	@Override
//	@Transactional
	public void addData(String data) {
		s1.insert(data);
		s2.insert(data);

	}

}
