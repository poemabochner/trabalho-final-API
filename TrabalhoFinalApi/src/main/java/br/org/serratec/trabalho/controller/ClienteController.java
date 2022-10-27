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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.org.serratec.trabalho.domain.Cliente;
import br.org.serratec.trabalho.dto.ClienteInserirDTO;
import br.org.serratec.trabalho.service.ClienteService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@ApiOperation(value="Retorna todos os clientes", notes="Clientes")
	@ApiResponses(value= {
	@ApiResponse(code=200, message="Retorna todo os clientes"),
	@ApiResponse(code=401, message="Erro de autenticação"),
	@ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
	@ApiResponse(code=404, message="Recurso não encontrado"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
	@GetMapping
	public ResponseEntity<List<Cliente>> buscaTodos() {
		List<Cliente> clientes = clienteService.buscarTodos();
		return ResponseEntity.ok(clientes);
	}
	
	@ApiOperation(value="Retorna um cliente por id", notes="Cliente")
	@ApiResponses(value= {
	@ApiResponse(code=200, message="Retorna um cliente por id"),
	@ApiResponse(code=401, message="Erro de autenticação"),
	@ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
	@ApiResponse(code=404, message="Recurso não encontrado"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscarCliente(@PathVariable Long id) {
		Cliente cliente = clienteService.buscaPorId(id);
		return ResponseEntity.ok(cliente);
	}
	
	@ApiOperation(value="Insere um novo cliente", notes="Cliente")
	@ApiResponses(value= {
	@ApiResponse(code=201, message="Cliente inserido com sucesso"),
	@ApiResponse(code=401, message="Erro de autenticação"),
	@ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
	@ApiResponse(code=404, message="Recurso não encontrado"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
	@PostMapping
	public ResponseEntity<Cliente> inserir(@Valid @RequestBody ClienteInserirDTO clienteInserirDTO) {
		Cliente cliente = clienteService.incluir(clienteInserirDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getIdCliente())
				.toUri();
		return ResponseEntity.created(uri).body(cliente);
	}
	
	@ApiOperation(value="Atualiza dados de um cliente", notes="Atualizar Cliente")
	@ApiResponses(value= {
	@ApiResponse(code=200, message="Cliente Atualizado"),
	@ApiResponse(code=201, message="Cliente Atualizado"),
	@ApiResponse(code=401, message="Erro de autenticação"),
	@ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
	@ApiResponse(code=404, message="Recurso não encontrado"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
	@PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.alterar(id, cliente));
    }
	
	@ApiOperation(value="Remove um cliente", notes="Cliente")
	@ApiResponses(value= {
	@ApiResponse(code=200, message="Cliente Removido"),
	@ApiResponse(code=401, message="Erro de autenticação"),
	@ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
	@ApiResponse(code=404, message="Recurso não encontrado"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		clienteService.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
