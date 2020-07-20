package com.example.demo;
 
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
 
 
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc; 
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.example.demo.controller.IndexController;

@SpringBootTest
class SpringBootDemo1ApplicationTests {
	
	private MockMvc mvc ;
	
	@BeforeTest
	void before() {
		mvc = MockMvcBuilders.standaloneSetup(new IndexController()).build();
	}
	@Test
	void contextLoads() throws Exception {
		RequestBuilder req = get("/index/index");
		
		mvc.perform(req).andExpect(status().isOk()).andExpect(content().string("hello world!"));
		
		
	} 
 
}
