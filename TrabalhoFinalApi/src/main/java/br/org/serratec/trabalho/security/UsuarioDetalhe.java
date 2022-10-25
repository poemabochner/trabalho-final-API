package br.org.serratec.trabalho.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.org.serratec.trabalho.domain.Usuario;
import br.org.serratec.trabalho.domain.UsuarioPerfil;

public class UsuarioDetalhe implements UserDetails {
	private Usuario usuario;

	public UsuarioDetalhe(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> lista = new ArrayList<>();
		for (UsuarioPerfil usuarioPerfil : usuario.getUsuarioPerfis()) {
			lista.add(new SimpleGrantedAuthority(usuarioPerfil.getPerfil().getNome()));
		}
		return lista;
	}

	@Override
	public String getPassword() {
		return usuario.getSenha();
	}

	@Override
	public String getUsername() {
		return usuario.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
