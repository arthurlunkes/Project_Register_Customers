package com.api.registercustomers.dtos;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class CustomerDTO {

	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@NotBlank
	private int idade;
	@NotBlank
	private String tipoCustomer;
	@NotBlank
	private Date dataNascimento;
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
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
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getTipoCustomer() {
		return tipoCustomer;
	}
	public void setTipoCustomer(String tipoCustomer) {
		this.tipoCustomer = tipoCustomer;
	}
	
}
