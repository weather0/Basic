package com.company.app.board;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "classpath:config/*-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@Log4j
public class BoardControllerTest {

	@Autowired
	private WebApplicationContext ctx;
	private MockMvc mockMvc;

	@Before // before: 테스트보다 먼저 실행 됨
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	@Test
	public void listTest() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/boardList")).andReturn().getModelAndView().getModelMap());
	}

	@Test
	public void inserTest() throws Exception {
		log.info(mockMvc
				.perform(MockMvcRequestBuilders.post("/boardInsert")
						.param("title", "mocKTest")
						.param("content", "내용테스트")
						.param("writer", "user02"))
				.andReturn().getModelAndView().getViewName());
	}

}
