package br.org.serratec.trabalho.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.trabalho.domain.Pedido;
import br.org.serratec.trabalho.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	public List<Pedido> buscarTodos() {
		return pedidoRepository.findAll();
	}

	public Pedido incluir(Pedido pedido) {
		pedido = pedidoRepository.save(pedido);
		return pedido;
	}

	public Pedido buscaPorId(Long id) {
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		return pedido.get();
	}
}
