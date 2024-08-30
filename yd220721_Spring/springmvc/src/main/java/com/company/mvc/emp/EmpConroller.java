package com.company.mvc.emp;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class EmpConroller {

	Logger logger = LoggerFactory.getLogger(EmpConroller.class);
	
	@Autowired
	EmpMapper mapper;

	// 단건조회
	@RequestMapping("/emp")
	public String emp(EmpVO vo, Model model, HttpServletRequest request) {
		logger.info("파라미터: " + vo.toString());
//		스프링은 주로 model을 씀(request써도 무방)
		model.addAttribute("emp", mapper.getEmp(vo));
//		request.setAttribute("emp", mapper.getEmp(vo));
		return "emp/emp";
	}

	// 목록
	@RequestMapping("/empList")
	public String empList(EmpReqVO vo, Model model) {
		model.addAttribute("emps", mapper.getEmpList(vo));
		return "emp/empList";
	}
	
	// 등록페이지 이동
	@GetMapping("/empInsert")
	public String empInsert() {
		return "emp/empInsert";
	}

	// 등록처리
//	@RequestMapping(value = "/empInsert", method = RequestMethod.POST) // = @PostMapping
	@PostMapping("/empInsert")
	public String empInsertProc(EmpVO vo) {
//		logger.debug(vo.toString());
		System.out.println(vo);
		mapper.insertEmp(vo);
		System.out.println(vo.getEmployeeId() + "사번 등록");
		return "redirect:empList"; // redirect 안쓰면 페이지이동해도 암것도 안 뜸
	}
	
	// 수정페이지
	@GetMapping("/empUpdate/{id}")
	public String empUpdateForm(Model model, EmpVO vo, @PathVariable String id) {
		vo.setEmployeeId(id);
		model.addAttribute("emp", mapper.getEmp(vo));
		return "emp/empUpdate";
	}
	
	// 수정처리
	@PostMapping("/empUpdate")
	public String empUpdateProc(EmpVO vo) {
		mapper.updateEmp(vo);
		return "redirect:empList";
	}
	
	// 삭제처리
	@GetMapping("/empDelete")
	public String empDeleteForm(Model model, EmpVO vo) {
		mapper.deleteEmp(vo);
		return "redirect:empList";
	}
	

}
