package com.company.mvc.emp;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
	// parameter.jsp파일을 views폴더에 넣은 경우: url과 파일명이 같은 경우 굳이 return 값 필요없다!!!
	@RequestMapping("parameter")
	public void parameter() {
		
	}
	
	// 다른 경우 리턴값 필수
	@RequestMapping("/paramtest")
	public String paramtest() {
		return "parameter";
	}
	
	// 이렇게 쓸수도 있는데 번거로워 잘 안 쓴다고
	@RequestMapping("/parameter2")
	public ModelAndView parameter2() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("parameter");
		mv.addObject("","");
		return mv;
	}

	// 교재132p.	
	// String[] request.getParameterValues()

	// 스트링, 배열, list로 받기
	@GetMapping("/array")
	public void array(@RequestParam String id, 
					@RequestParam String[] ids, 
					@RequestParam List<String> idList, 
					HttpServletResponse response) throws IOException {
		
		// 웹에 표시하기
		PrintWriter out = response.getWriter();
		out.print(id + "\n");
		out.print(ids[0] + "\n");
		out.print(idList);
		// 주소에 /array?id=aaa&ids=a1&ids=a2&ids=a3&idList=l1&idList=l2&idList=l3
	}
	
	
	
	@RequestMapping("/req1")
	public void req1(HttpServletResponse response, 
					@RequestParam(required = false, defaultValue = "park") String id) {  
		// "@RequestParam" 생략 가능
		// @RequestParam의 옵션: required, defaultValue 등
		
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out;
			out = response.getWriter();
			out.print(id);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@RequestMapping("/req2")
	public void req1(HttpServletResponse response, String[] ids) {  
		
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out;
			out = response.getWriter();
			out.print(ids[0] + "\n" + ids[1]);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	@RequestMapping("/req3")
	public void req1(HttpServletResponse response, @RequestParam Map<String, Object> map) {  
		
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out;
			out = response.getWriter();
			out.print(map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("/req4")
	public void req1(HttpServletResponse response, TestVO vo) {  
		
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out;
			out = response.getWriter();
			out.print(vo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	
	@RequestMapping("/req5")
	public void req1(HttpServletResponse response, TestListVO vo) {  
		
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out;
			out = response.getWriter();
			out.print(vo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	@RequestMapping("/req6")
	public void req1(HttpServletResponse response, TestVO vo, MultipartFile[] pic){  
		
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out;
			out = response.getWriter();
			
			// 첨부파일 업로드
			for(MultipartFile temp : pic)
			if(temp != null && temp.getSize() > 0) {
				File file = new File ("d:/upload", temp.getOriginalFilename());
				temp.transferTo(file);
				out.print(temp.getOriginalFilename()+"<br>");
				out.print(temp.getSize()+"<hr>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	@RequestMapping("/req7/{id}/{age}")
	public void req1(HttpServletResponse response, @PathVariable String id, @PathVariable int age) {  
		
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out;
			out = response.getWriter();
			out.println(id);
			out.print(age);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
