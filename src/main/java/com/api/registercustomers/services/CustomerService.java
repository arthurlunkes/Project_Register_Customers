package com.api.registercustomers.services;

import org.springframework.stereotype.Service;

import com.api.registercustomers.models.CustomerModel;
import com.api.registercustomers.repositories.CustomerRepository;

import jakarta.transaction.Transactional;

@Service
public class CustomerService {
	
	final CustomerRepository customerRepository;
	
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	@Transactional
	public CustomerModel save(CustomerModel customerModel) {
		return customerRepository.save(customerModel);
	}
	
}
