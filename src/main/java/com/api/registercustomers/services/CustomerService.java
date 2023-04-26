package com.api.registercustomers.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
	
	public List<CustomerModel> findAll() {
		return customerRepository.findAll();
	}
	
	public Optional<CustomerModel> findById(UUID id) {
		return customerRepository.findById(id);
	}
	
	@Transactional
	public void delete(CustomerModel customerModel) {
		customerRepository.delete(customerModel);
	}
	
}
