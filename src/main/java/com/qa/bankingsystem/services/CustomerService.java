package com.qa.bankingsystem.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.bankingsystem.domain.Customer;
import com.qa.bankingsystem.exception.CustomerNotFoundException;
import com.qa.bankingsystem.repo.CustomerRepo;

@Service
public class CustomerService {

	private CustomerRepo repo;

	public CustomerService(CustomerRepo repo) {
		this.repo = repo;
	}

	public Customer create(Customer customer) {
		return repo.saveAndFlush(customer);
	}

	public List<Customer> getAll() {
		return repo.findAll();
	}

	public Customer getById(long id) {
		return repo.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
	}

	public Customer update(long id, Customer customer) {
		Customer customerToEdit = repo.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
		customerToEdit.setFirstName(customer.getFirstName());
		customerToEdit.setLastName(customer.getLastName());
		customerToEdit.setAddress(customer.getAddress());
		return repo.saveAndFlush(customerToEdit);
	}

	public boolean delete(long id) {
		repo.deleteById(id);
		return !repo.existsById(id);
	}
}
