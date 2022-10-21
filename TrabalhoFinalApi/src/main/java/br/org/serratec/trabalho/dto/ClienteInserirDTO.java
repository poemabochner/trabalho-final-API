package br.org.serratec.trabalho.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ClienteInserirDTO {

	private String nomeCompleto;

	private String email;

	private String cpf;

	private String telefone;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;

	private String cepInserido;

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
