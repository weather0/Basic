package com.company.mvc.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // = @Controller + @ResponseBody 일괄적용
@CrossOrigin(origins = "*") // CORS오류 해결
public class TodoController {
	@Autowired TodoMapper mapper;
	
	// (교재361p)mime타입
	@GetMapping(value="/getText", produces = "text/plain; charset=utf-8") 
	public String getText() {
		return "ㅋㅋㅋㅋ";
	}
	
	
	@GetMapping("/todo/{no}")
	public TodoVO todoSelect(@PathVariable int no) {
		return mapper.findById(no);
	}
	
	
	@GetMapping("/check")
	public List<TodoVO> check(TodoVO vo) {
		int a = 5/0;
		return mapper.findAll(vo);
	}
	
	
	// getmapping 기본적으로 json으로 자동변환해주기 때문에 MediaType.APPLICATION_JSON_VALUE는 굳이 안적어줘도 됨
	@GetMapping(value="/todo", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<TodoVO> todoList(TodoVO vo) {
		return mapper.findAll(vo);
	}
	
	
	@GetMapping(value="/todo2", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<TodoVO>> todoList2(TodoVO vo) {
		int a = 5/0;
		List<TodoVO> list = mapper.findAll(vo);
		return new ResponseEntity<List<TodoVO>>(list,HttpStatus.OK);
	}
	
	
	
	// POST테스트하기: 브라우저 추가기능(확장) boomerang REST설치
	@PostMapping("/todo")
	public TodoVO todoInsert(TodoVO vo) {
		mapper.persist(vo);
		return vo;
	}
	
	// 주의! PUT방식은 요청값으로 반드시 JSON만 받는다!
	@PutMapping("/todo")
	public TodoVO todoUpdate(@RequestBody TodoVO vo) { // @RequestBody -> json파싱해줌
		mapper.merge(vo);
		return vo;
	}
	
	@DeleteMapping("/todo/{no}")
	public int todoDelete(@PathVariable int no) {
		mapper.remove(no);
		return no;
	}
	
	
}
