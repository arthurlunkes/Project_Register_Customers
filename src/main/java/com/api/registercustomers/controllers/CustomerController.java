package com.api.registercustomers.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping
	public ResponseEntity<List<CustomerModel>>  getAllCustomers(){
		return ResponseEntity.status(HttpStatus.OK).body(customerService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneCustomer(@PathVariable(value = "id") UUID id) {
		Optional<CustomerModel> customerModelOptional = customerService.findById(id);
		if(!customerModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");
		}
		return ResponseEntity.status(HttpStatus.OK).body(customerModelOptional.get());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable(value = "id") UUID id,
										@RequestBody @Valid CustomerDTO customerDto) {
		Optional<CustomerModel> customerModelOptional = customerService.findById(id);
		if(!customerModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");
		}
		var customerModel = customerModelOptional.get();
		customerModel.setIdade(customerDto.getIdade());
		customerModel.setNome(customerDto.getNome());
		customerModel.setSobrenome(customerDto.getSobrenome());
		customerModel.setTipoCustomer(customerDto.getTipoCustomer());
		return ResponseEntity.status(HttpStatus.OK).body(customerService.save(customerModel));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCustomer(@PathVariable(value = "id") UUID id){
		Optional<CustomerModel> customerModelOptional = customerService.findById(id);
		if(!customerModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body("Cliente não encontrado!");
		}
		customerService.delete(customerModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado com sucesso!");
	}

}
