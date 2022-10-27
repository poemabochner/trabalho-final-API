package br.org.serratec.trabalho.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;

import br.org.serratec.trabalho.domain.Perfil;
import br.org.serratec.trabalho.domain.Usuario;
import br.org.serratec.trabalho.domain.UsuarioPerfil;
import io.swagger.annotations.ApiModelProperty;

public class UsuarioDTO {
	@ApiModelProperty(value="Identificador unico de usuario")
	private Long id;
	
	@NotBlank
	@ApiModelProperty(value="Nome do usuario", required = true)
	private String nome;
	
	@NotBlank
	@ApiModelProperty(value="Email do usuario", required = true)
	private String email;
	
	@ApiModelProperty(value="Perfil do usuario", required = true)
	private Set<Perfil> perfis;

	public UsuarioDTO(Long id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
	}

	public UsuarioDTO() {
		super();
	}

	public UsuarioDTO(Usuario usuario) {
		super();
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.perfis = new HashSet<>();
		for (UsuarioPerfil usuarioPerfil : usuario.getUsuarioPerfis()) {
			this.perfis.add(usuarioPerfil.getPerfil());
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Set<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(Set<Perfil> perfis) {
		this.perfis = perfis;
	}

}
