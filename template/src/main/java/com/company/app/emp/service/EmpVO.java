package com.company.app.emp.service;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class EmpVO {
	private String employeeId;
	private String firstName;
	private String lastName;
	private String email;
	// java.util.Date일 경우: @DateTimeFormat: String parameter를 Date로 변환(없으면 400번 에러 남)
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	private Date hireDate;
	private String jobId;
	private String salary;
	private String departmentId;
	
	private List<DepVO> depts;

}
