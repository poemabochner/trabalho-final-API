package br.org.serratec.trabalho.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.trabalho.domain.Pedido;
import br.org.serratec.trabalho.exception.DataNotFoundException;
import br.org.serratec.trabalho.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	public List<Pedido> buscarTodos() {
		return pedidoRepository.findAll();
	}

	public Pedido buscaPorId(Long id) {
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		if (!pedido.isPresent()) {
			throw new DataNotFoundException("O produto com o id:" + id + " não foi encontrado");
		}
		return pedido.get();
	}

//	public Pedido incluir(PedidoInserirDTO pedidoInserirDTO) {
//
//		Pedido pedido = new Pedido();
//		
//		
//		List<PedidoIten> lista = new ArrayList<>();
//		
//		for (PedidoItenInseridoDTO pedidoItenInserir : pedidoInserirDTO.getItensInseridos()) {
//			PedidoIten pedidoiten = new PedidoIten();
//			pedidoiten.setPercentual_desconto(pedidoItenInserir.getPercentualDesconto());
//			pedidoiten.set
//			
//			
//			
//			
//			lista.add(pedidoiten);
//		}
//		
//		
//		pedido.setPedidoIten(lista);
//		
//		
//		Pedido pedido = pedidoRepository.save(pedido);
//		return pedido;
//	}

	public void deletar(Long id) {
		Optional<Pedido> produtoBanco = pedidoRepository.findById(id);
		if (!produtoBanco.isPresent()) {
			throw new DataNotFoundException("O produto com o id:" + id + " não foi encontrado");
		}
		pedidoRepository.deleteById(id);
	}
}
