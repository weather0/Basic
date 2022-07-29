package com.company.app.emp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.app.emp.mapper.EmpMapper;
import com.company.app.emp.service.DepVO;
import com.company.app.emp.service.EmpVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/*-context.xml")
public class EmpMapperTest {
	@Autowired EmpMapper mapper;
	@Test
	public void test() {
		System.out.println("=================");
//		System.out.println(mapper.getEmpDept());
		
		for(DepVO dept : mapper.getDeptEmps()) {
			System.out.println("==dept: " + dept.getDepartmentName());
			for(EmpVO emp : dept.getEmp()) {
				System.out.println(emp.getFirstName() + ",");
				
			}
		}
		
		
	}
}
