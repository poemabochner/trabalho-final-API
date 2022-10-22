package br.org.serratec.trabalho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.trabalho.domain.Pedido;
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

//	@PostMapping
//	public ResponseEntity<Pedido> inserir(@Valid @RequestBody PedidoInserirDTO pedidoInserirDTO) {
//		Pedido pedido = pedidoService.incluir(pedidoInserirDTO);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pedido.getIdPedido())
//				.toUri();
//		return ResponseEntity.created(uri).body(pedido);
//	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		pedidoService.deletar(id);
		return ResponseEntity.noContent().build();
	}
}
