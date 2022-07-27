package com.company.app.emp.mapper;

import java.util.List;
import com.company.app.emp.service.EmpReqVO;
import com.company.app.emp.service.EmpVO;

public interface EmpMapper {
	public EmpVO getEmp(EmpVO vo);
	public List<EmpVO> getEmpList(EmpReqVO vo);
	public List<EmpVO> getEmpByDept(String[] dept);
	int insert(EmpVO vo);
}
