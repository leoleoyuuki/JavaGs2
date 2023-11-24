package br.com.fiap.hydrovital.model.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Agua {

	@NotBlank
	private String qualidade;
	@NotBlank
	private String quantidadeAgua;
	@NotBlank
	private String quantidadeProd;
	@NotBlank
	private String quantidadePessoa;
	@NotNull
	private Long id;
	@NotBlank
	private String cnpj;
	
	public Agua() {
	}
	
	public Agua(@NotBlank String qualidade, @NotBlank String quantidadeAgua, @NotBlank String quantidadeProd,
			@NotBlank String quantidadePessoa, @NotNull Long id, @NotBlank String cnpj) {
		this.qualidade = qualidade;
		this.quantidadeAgua = quantidadeAgua;
		this.quantidadeProd = quantidadeProd;
		this.quantidadePessoa = quantidadePessoa;
		this.id = id;
		this.cnpj = cnpj;
	}
	
	public String getQualidade() {
		return qualidade;
	}
	public void setQualidade(String qualidade) {
		this.qualidade = qualidade;
	}
	public String getQuantidadeAgua() {
		return quantidadeAgua;
	}
	public void setQuantidadeAgua(String quantidadeAgua) {
		this.quantidadeAgua = quantidadeAgua;
	}
	public String getQuantidadeProd() {
		return quantidadeProd;
	}
	public void setQuantidadeProd(String quantidadeProd) {
		this.quantidadeProd = quantidadeProd;
	}
	public String getQuantidadePessoa() {
		return quantidadePessoa;
	}
	public void setQuantidadePessoa(String quantidadePessoa) {
		this.quantidadePessoa = quantidadePessoa;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
		
	}


		
}
