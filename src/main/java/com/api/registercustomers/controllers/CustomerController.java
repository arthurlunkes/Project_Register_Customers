package com.api.registercustomers.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.registercustomers.dtos.CustomerDTO;
import com.api.registercustomers.models.CustomerModel;
import com.api.registercustomers.services.CustomerService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/customers")
public class CustomerController {
	
	final CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@PostMapping
	public ResponseEntity<Object> saveCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
		var customerModel = new CustomerModel();
		BeanUtils.copyProperties(customerDTO, customerModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(customerModel));
	}

}
