package br.org.serratec.trabalho.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class ClienteInserirDTO {

	@NotBlank
	@ApiModelProperty(value="Nome do cliente", required = true)
	private String nomeCompleto;

	@NotBlank
	@ApiModelProperty(value="Email do cliente", required = true)
	private String email;

	@NotBlank
	@ApiModelProperty(value="CPF do cliente", required = true)
	private String cpf;

	@NotBlank
	@ApiModelProperty(value="Telefone do cliente", required = true)
	private String telefone;

	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
	@ApiModelProperty(value="Data de nascimento do cliente", required = true)
	private LocalDate dataNascimento;

	@NotBlank
	@ApiModelProperty(value="Cep do cliente", required = true)
	private String cepInserido;

	@NotBlank
	@ApiModelProperty(value="Numero do cliente", required = true)
	private String numeroInserido;

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCepInserido() {
		return cepInserido;
	}

	public void setCepInserido(String cepInserido) {
		this.cepInserido = cepInserido;
	}

	public String getNumeroInserido() {
		return numeroInserido;
	}

	public void setNumeroInserido(String numeroInserido) {
		this.numeroInserido = numeroInserido;
	}

}
