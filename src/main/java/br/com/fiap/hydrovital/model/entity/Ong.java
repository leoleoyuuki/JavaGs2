package br.com.fiap.hydrovital.model.entity;

import jakarta.validation.constraints.NotBlank;

public class Ong {
	
	@NotBlank
	private String nome;
	@NotBlank
	private String localidade;
	@NotBlank
	private String cnpj;
	@NotBlank
	private String telefone;
	@NotBlank
	private String email;
	@NotBlank
	private String cpf;
	
	
	public Ong() {
	}
	
	public Ong(@NotBlank String nome, @NotBlank String localidade, @NotBlank String cnpj, @NotBlank String telefone,
			@NotBlank String email, @NotBlank String cpf) {
		this.nome = nome;
		this.localidade = localidade;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.email = email;
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLocalidade() {
		return localidade;
	}
	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
		
	}

	
	
}
