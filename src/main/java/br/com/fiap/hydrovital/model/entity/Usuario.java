package br.com.fiap.hydrovital.model.entity;

import jakarta.validation.constraints.NotBlank;

public class Usuario {
	
	@NotBlank
	private String nome;
	@NotBlank
	private String telefone;
	@NotBlank
	private String cpf;
	@NotBlank
	private String email;
	@NotBlank
	private String dataDeNascimento;
	
	
	public Usuario() {
	}
	
	public Usuario(@NotBlank String nome, @NotBlank String telefone, @NotBlank String cpf, @NotBlank String email,
			@NotBlank String dataDeNascimento) {
		this.nome = nome;
		this.telefone = telefone;
		this.cpf = cpf;
		this.email = email;
		this.dataDeNascimento = dataDeNascimento;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDataDeNascimento() {
		return dataDeNascimento;
	}
	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	
	

}
