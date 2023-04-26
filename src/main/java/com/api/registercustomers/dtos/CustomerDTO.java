package com.api.registercustomers.dtos;

import jakarta.validation.constraints.NotBlank;


public class CustomerDTO {

	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@NotBlank
	private String idade;
	@NotBlank
	private String tipoCustomer;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	public String getTipoCustomer() {
		return tipoCustomer;
	}
	public void setTipoCustomer(String tipoCustomer) {
		this.tipoCustomer = tipoCustomer;
	}
	
}
