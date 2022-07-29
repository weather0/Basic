package com.company.app.emp.mapper;

import java.util.List;

import com.company.app.emp.service.DepVO;
import com.company.app.emp.service.EmpReqVO;
import com.company.app.emp.service.EmpVO;

public interface EmpMapper {
	public EmpVO getEmp(EmpVO empVO);
	public List<EmpVO> getEmpList(EmpReqVO vo);
	public void insertEmp(EmpVO vo);
	public void updateEmp(EmpVO vo);
	public void deleteEmp(EmpVO vo);
	
	public List<EmpVO> getEmpDept();
	public List<DepVO> getDeptEmps();
}
