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
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.bankingsystem.domain.Customer;
import com.qa.bankingsystem.services.CustomerService;

@WebMvcTest
public class CustomerControllerUnitTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@MockBean
	private CustomerService service;
	
	@Test
	public void createTest() throws Exception {
		Customer input = new Customer("Tim", "Timson", "123 Address road, RO4 4AD");
		String inputAsJSON = mapper.writeValueAsString(input);
		
		Mockito.when(service.create(input)).thenReturn(input);
		
		mvc.perform(post("/customer/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(inputAsJSON))
				.andExpect(status().isCreated())
				.andExpect(content().json(inputAsJSON));
	}
	
	@Test
	public void getAllTest() throws Exception {
		Customer customer = new Customer(1L, "Tom", "Tomsom", "123 address place");
		List<Customer> output = new ArrayList<>();
		output.add(customer);
		String outputAsJSON = mapper.writeValueAsString(output);
		
		Mockito.when(service.getAll()).thenReturn(output);
		
		mvc.perform(get("/customer/getAll")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(outputAsJSON));
	}
	
	@Test 
	public void getByIdTest() throws Exception {
		Customer entry = new Customer(1L, "Tom", "Tomsom", "123 address place");
		String entryAsJSON = mapper.writeValueAsString(entry);
		
		Mockito.when(service.getById(1L)).thenReturn(entry);
		
		mvc.perform(get("/customer/getById/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(entryAsJSON));
	}
	
	@Test
	public void updateTest() throws Exception {
		Customer input = new Customer("Tim", "Timson", "123 Address road, RO4 4AD");
		String inputAsJSON = mapper.writeValueAsString(input);
		
		Mockito.when(service.update(1L, input)).thenReturn(input);
		
		mvc.perform(put("/customer/update/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(inputAsJSON))
				.andExpect(status().isAccepted())
				.andExpect(content().json(inputAsJSON));
	}
	
	@Test
	public void deleteTest() throws Exception {
		Mockito.when(service.delete(1L)).thenReturn(true);
		
		mvc.perform(delete("/customer/delete/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());
	}
}
