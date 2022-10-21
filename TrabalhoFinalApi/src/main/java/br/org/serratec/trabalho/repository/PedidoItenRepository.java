package br.org.serratec.trabalho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.serratec.trabalho.domain.PedidoIten;

@Repository
public interface PedidoItenRepository extends JpaRepository<PedidoIten, Long> {

}
