package br.org.serratec.trabalho.dto;

import java.util.Set;

import br.org.serratec.trabalho.domain.Perfil;

public class UsuarioInserirDTO {
	private String nome;
	private String email;
	private String senha;
	private String confirmaSenha;
	private Set<Perfil> perfis;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}

	public Set<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfils(Set<Perfil> perfis) {
		this.perfis = perfis;
	}

}
