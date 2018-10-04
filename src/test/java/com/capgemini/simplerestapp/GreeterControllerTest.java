package com.capgemini.simplerestapp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capgemini.simplerestapp.controller.GreeterController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GreeterControllerTest {
	
	@InjectMocks
	private GreeterController greeterController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(greeterController).build();
	}
	
	@Test
	public void testGreetWhichReturnsStringContent() throws Exception {
		mockMvc.perform(get("/greet/john"))
		              .andExpect(status().isOk())
		              .andExpect(content().string("Hello : john"));
	}
	
	@Test
	public void testGreetWhichReturnsGreeterObject() throws Exception {
		mockMvc.perform(get("/greet").accept(MediaType.APPLICATION_JSON))				                   			     
		              .andExpect(status().isOk())
		              .andExpect(content().json("{\"title\": \"greet\", \"message\":\"Hello....\"}"))
		              .andDo(print());
		             /* .andExpect(jsonPath("$.title").value("greet"))
		              .andExpect(jsonPath("$.message").value("Hello...."))
		              .andDo(print());*/
	}
	
	@Test
	public void testAddGreeterWhichAddsGreeterObject() throws Exception {
		mockMvc.perform(post("/greet").
				               contentType(MediaType.APPLICATION_JSON)
				               .content("{\"title\": \"Hi\", \"message\": \"hello\"}")
				               .accept(MediaType.APPLICATION_JSON))
		                     .andExpect(status().isOk())
		                     .andExpect(jsonPath("$.title").exists())
		                     .andExpect(jsonPath("$.message").exists())
		                     .andExpect(jsonPath("$.title").value("Hi"))
		                     .andExpect(jsonPath("$.message").value("hello"))
		                     .andDo(print());		              
	}
}







