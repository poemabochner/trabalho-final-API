package br.org.serratec.trabalho.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.org.serratec.trabalho.domain.Pedido;
import br.org.serratec.trabalho.repository.PedidoRepository;
import br.org.serratec.trabalho.service.PedidoService;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;

	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping
	public ResponseEntity<List<Pedido>> buscaTodos() {
		List<Pedido> pedidos = pedidoService.buscarTodos();
		return ResponseEntity.ok(pedidos);
	}

	@PostMapping
	public ResponseEntity<Pedido> inserir(@Valid @RequestBody Pedido pedido) {
		pedido = pedidoService.incluir(pedido);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pedido.getIdPedido())
				.toUri();
		return ResponseEntity.created(uri).body(pedido);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pedido> buscarPedido(@PathVariable Long id) {
		Pedido pedido = pedidoService.buscaPorId(id);
		return ResponseEntity.ok(pedido);
	}
}
