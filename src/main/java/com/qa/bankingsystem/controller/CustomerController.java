package com.qa.bankingsystem.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.bankingsystem.domain.Customer;
import com.qa.bankingsystem.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	private CustomerService service;

	public CustomerController(CustomerService service) {
		this.service = service;
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Customer>> getAll() {
		return new ResponseEntity<List<Customer>>(service.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Customer> getById(@PathVariable long id) {
		return new ResponseEntity<Customer>(service.getById(id), HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Customer> create(@RequestBody Customer customer) {
		return new ResponseEntity<Customer>(service.create(customer), HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Customer> update(@PathVariable long id, @RequestBody Customer customer) {
		return new ResponseEntity<Customer>(service.update(id, customer), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable long id) {
		return service.delete(id) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) :
			new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
