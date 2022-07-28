package com.example.demo;

import java.util.List;

public interface EmpMapper {
	public EmpVO getEmp(EmpVO empVO);
	public List<EmpVO> getEmpList();
	public void empInsert(EmpVO empVO);
	
	public List<DepVO> getDepartments();
	public List<JobVO> getJobs();
}
