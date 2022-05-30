package com.qa.bankingsystem.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND, reason="Customer does not exist with that ID")
public class CustomerNotFoundException extends NoSuchElementException{
	
	public CustomerNotFoundException(long id) {
		super("User does not exist with ID -" + id);
	}

}
