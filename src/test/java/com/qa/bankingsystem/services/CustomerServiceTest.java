package com.qa.bankingsystem.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.qa.bankingsystem.domain.Customer;
import com.qa.bankingsystem.repo.CustomerRepo;

@SpringBootTest
public class CustomerServiceTest {
//
	@Autowired
	private CustomerService service;

	@MockBean
	private CustomerRepo repo;
	
	@Test
	public void createTest() {
		Customer input = new Customer("Jim", "Jimson", "123 Road, City, RO4 4AD");
		Customer output = new Customer(1L, "Jim", "Jimson", "123 Road, City, RO4 4AD");
		
		Mockito.when(repo.saveAndFlush(input)).thenReturn(output);
		
		assertEquals(output, service.create(input));

		Mockito.verify(repo, Mockito.times(1)).saveAndFlush(input);
	}

	@Test
	public void getAllTest() {
		List<Customer> output = new ArrayList<>();
		output.add(new Customer(1L, "Jim", "Jimson", "123 Road, City, RO4 4AD"));

		Mockito.when(repo.findAll()).thenReturn(output);

		assertEquals(output, service.getAll());

		Mockito.verify(repo, Mockito.times(1)).findAll();
	}
	
	@Test
	public void getByIdTest() {
		Customer output = new Customer(1L, "Jim", "Jimson", "123 Road, City, RO4 4AD");
		Optional<Customer> optionalOutput = Optional.of(output);
		
		Mockito.when(repo.findById(1L)).thenReturn(optionalOutput);
		
		assertEquals(output, service.getById(1L));
		
		Mockito.verify(repo, Mockito.times(1)).findById(1L);
	}
	
	@Test
	public void updateTest() {
		Customer input = new Customer("Jim", "Jimson", "123 Road, City, RO4 4AD");
		Optional<Customer> existing = Optional.of(new Customer(1L, "Jimmy", "Jimison", "address"));
		Customer output = new Customer(1L, "Jim", "Jimson", "123 Road, City, RO4 4AD");
		
		Mockito.when(repo.findById(1L)).thenReturn(existing);
		Mockito.when(repo.saveAndFlush(output)).thenReturn(output);
		
		assertEquals(output, service.update(1L, input));
		
		Mockito.verify(repo, Mockito.times(1)).saveAndFlush(output);
		Mockito.verify(repo, Mockito.times(1)).findById(1L);	
	}
	
	@Test
	public void deleteTest() {
		Mockito.when(repo.existsById(1L)).thenReturn(false);
		
		assertEquals(true, service.delete(1L));
		
		Mockito.verify(repo, Mockito.times(1)).existsById(1L);
	}
}
