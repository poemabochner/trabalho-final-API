package br.org.serratec.trabalho.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "usuario_perfil")
public class UsuarioPerfil {

	@EmbeddedId
	private UsuarioPerfilPK usuarioPerfilPK = new UsuarioPerfilPK();
	@Column(name = "data_criacao")
	private LocalDate dataCadastro;

	public UsuarioPerfil() {
	}

	public UsuarioPerfil(Usuario usuario, Perfil perfil, LocalDate dataCadastro) {
		this.usuarioPerfilPK.setIdUsuario(usuario);
		this.usuarioPerfilPK.setIdPerfil(perfil);
		this.dataCadastro = dataCadastro;
	}

	public UsuarioPerfilPK getUsuarioPerfilPK() {
		return usuarioPerfilPK;
	}

	public void setUsuarioPerfilPK(UsuarioPerfilPK usuarioPerfilPK) {
		this.usuarioPerfilPK = usuarioPerfilPK;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public void setUsuario(Usuario usuario) {
		this.usuarioPerfilPK.setIdUsuario(usuario);
	}

	public Usuario getUsuario() {
		return this.usuarioPerfilPK.getIdUsuario();
	}

	public void setPerfil(Perfil perfil) {
		this.usuarioPerfilPK.setIdPerfil(perfil);
	}

	public Perfil getPerfil() {
		return this.usuarioPerfilPK.getIdPerfil();
	}

}
