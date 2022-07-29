package com.company.app.emp.service;

import java.util.List;

import lombok.Data;

@Data
public class DepVO {

	private Long departmentId;
	private String departmentName;
	private Integer managerId;
	private Integer locationId;
	
	private List<EmpVO> emp;
}
