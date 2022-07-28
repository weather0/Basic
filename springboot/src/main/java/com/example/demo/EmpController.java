package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmpController {
	@Autowired
	EmpMapper dao;

	@RequestMapping("/empList")
	public String empList(Model model) {
		model.addAttribute("empList", dao.getEmpList());
		return "empList";
	}
	
	@RequestMapping("/thymeleafTest")
	public String thymeleafTest(Model model) {
		model.addAttribute("str1","<u>test</u>");
		return "thymeleafTest";
	}
	
	
	@RequestMapping("/empInsert")
	public String empInsertform(Model model) {
		model.addAttribute("deps", dao.getDepartments());
		model.addAttribute("jobs", dao.getJobs());
		return "empInsert";
	}	
	
	@PostMapping("/empInsert")
	public String empInsertProc(EmpVO vo) {
		dao.empInsert(vo);
		return "rediect:empList";
	}

	
	
	@ModelAttribute("jobs")
	public List<JobVO> getJobs(){
		return dao.getJobs();
	}
	@ModelAttribute("deps")
	public List<DepVO> getDepartments(){
		return dao.getDepartments();
	}
	
	
	@GetMapping("/empUpdate")
	public String empUpdatetform(Model model, EmpVO vo) {
		model.addAttribute("emp", dao.getEmp(vo));
		return "empUpdate";
	}	
	
	
	
}
