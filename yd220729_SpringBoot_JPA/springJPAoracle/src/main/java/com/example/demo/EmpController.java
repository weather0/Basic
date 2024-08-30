package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmpController {
	@Autowired
	EmployeesRepository dao;

	@RequestMapping("/empList")
	public String empList(Model model) {
		model.addAttribute("emps", dao.findAll());
		return "empList";
	}
}
