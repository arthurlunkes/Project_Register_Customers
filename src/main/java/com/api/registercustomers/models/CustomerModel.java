package com.api.registercustomers.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_CUSTOMER")
public class CustomerModel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column(nullable = false, length = 60)
	private String nome;
	@Column(nullable = false, length = 60)
	private String sobrenome;
	@Column(nullable = false, length = 3)
	private String idade;
	@Column(nullable = false, length = 20)
	private String tipoCustomer;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
