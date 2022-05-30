package com.qa.bankingsystem.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends NoSuchElementException{
	
	public CustomerNotFoundException(long id) {
		super("User does not exist with the ID " + id);
	}

}
