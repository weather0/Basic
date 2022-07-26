package com.company.app.emp.service;

import java.util.List;

import com.company.app.emp.service.EmpReqVO;
import com.company.app.emp.service.EmpVO;

public interface EmpService {
	public EmpVO getEmp(EmpVO vo);
	public List<EmpVO> getEmpList(EmpReqVO vo);
	public void insertEmp(EmpVO vo);
	public void updateEmp(EmpVO vo);
	public void deleteEmp(EmpVO vo);
}
