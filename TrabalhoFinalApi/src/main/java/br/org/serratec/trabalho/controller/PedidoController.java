package br.org.serratec.trabalho.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.org.serratec.trabalho.domain.Pedido;
import br.org.serratec.trabalho.dto.PedidoInserirDTO;
import br.org.serratec.trabalho.dto.RelatorioDTO;
import br.org.serratec.trabalho.exception.DataPedidoException;
import br.org.serratec.trabalho.service.PedidoService;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;

	@GetMapping
	public ResponseEntity<List<Pedido>> buscaTodos() {
		List<Pedido> pedidos = pedidoService.buscarTodos();
		return ResponseEntity.ok(pedidos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pedido> buscarPedido(@PathVariable Long id) {
		Pedido pedido = pedidoService.buscaPorId(id);
		return ResponseEntity.ok(pedido);
	}

	@GetMapping("/relatorio")
	public ResponseEntity<List<RelatorioDTO>> listar() {
		return ResponseEntity.ok(pedidoService.buscarTodosRelatorios());
	}

	@PostMapping
	public ResponseEntity<Pedido> inserir(@Valid @RequestBody PedidoInserirDTO pedidoInserirDTO)
			throws DataPedidoException {
		Pedido pedido = pedidoService.incluir(pedidoInserirDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pedido.getIdPedido())
				.toUri();
		return ResponseEntity.created(uri).body(pedido);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		pedidoService.deletar(id);
		return ResponseEntity.noContent().build();
	}
}
