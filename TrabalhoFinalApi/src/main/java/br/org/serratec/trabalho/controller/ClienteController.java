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

import br.org.serratec.trabalho.domain.Cliente;
import br.org.serratec.trabalho.service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public ResponseEntity<List<Cliente>> buscaTodos() {
		List<Cliente> clientes = clienteService.buscarTodos();
		return ResponseEntity.ok(clientes);
	}

	@PostMapping
	public ResponseEntity<Cliente> inserir(@Valid @RequestBody Cliente cliente) {
		cliente = clienteService.incluir(cliente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getIdCliente())
				.toUri();
		return ResponseEntity.created(uri).body(cliente);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscarCliente(@PathVariable Long id) {
		Cliente cliente = clienteService.buscaPorId(id);
		return ResponseEntity.ok(cliente);
	}
}
