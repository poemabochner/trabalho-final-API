package br.org.serratec.trabalho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.serratec.trabalho.domain.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {

}
