package com.qa.bankingsystem.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.bankingsystem.domain.Customer;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:testschema.sql", "classpath:testdata.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class CustomerControllerIntegrationTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;

	@Test
	public void createTest() throws Exception {
		Customer input = new Customer("Tim", "Timson", "123 Address road, RO4 4AD");
		String inputAsJSON = mapper.writeValueAsString(input);
		
		Customer output = new Customer(2L, "Tim", "Timson", "123 Address road, RO4 4AD");
		String outputAsJSON = mapper.writeValueAsString(output);
		
		mvc.perform(post("/customer/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(inputAsJSON))
				.andExpect(status().isCreated())
				.andExpect(content().json(outputAsJSON));
	}
	
	@Test
	public void getAllTest() throws Exception {
		Customer customer = new Customer(1L, "Tom", "Tomsom", "123 address place");
		List<Customer> output = new ArrayList<>();
		output.add(customer);
		
		String outputAsJSON = mapper.writeValueAsString(output);
		
		mvc.perform(get("/customer/getAll")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(outputAsJSON));
	}
	
	@Test 
	public void getByIdTest() throws Exception {
		Customer entry = new Customer(1L, "Tom", "Tomsom", "123 address place");
		String entryAsJSON = mapper.writeValueAsString(entry);
		
		mvc.perform(get("/customer/getById/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(entryAsJSON));
	}
	
	@Test
	public void updateTest() throws Exception {
		Customer input = new Customer("Tim", "Timson", "123 Address road, RO4 4AD");
		String inputAsJSON = mapper.writeValueAsString(input);
		
		Customer output = new Customer(1L, "Tim", "Timson", "123 Address road, RO4 4AD");
		String outputAsJSON = mapper.writeValueAsString(output);
		
		mvc.perform(put("/customer/update/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(inputAsJSON))
				.andExpect(status().isAccepted())
				.andExpect(content().json(outputAsJSON));
	}
	
	@Test
	public void deleteTest() throws Exception {
		mvc.perform(delete("/customer/delete/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());
	}
}
