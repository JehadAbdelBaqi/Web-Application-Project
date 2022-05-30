package com.qa.bankingsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.bankingsystem.domain.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
}
