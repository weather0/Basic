package com.company.mvc.emp;

import java.util.List;
import java.util.Map;

public interface EmpMapper {
	public Map<String, Object> getEmp(EmpVO empVO);
	public List<EmpVO> getEmpList(EmpVO vo);

}
