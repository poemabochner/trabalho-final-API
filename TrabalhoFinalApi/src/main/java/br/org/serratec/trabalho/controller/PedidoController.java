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

import br.org.serratec.trabalho.domain.Pedido;
import br.org.serratec.trabalho.dto.PedidoInserirDTO;
import br.org.serratec.trabalho.dto.RelatorioDTO;
import br.org.serratec.trabalho.exception.DataPedidoException;
import br.org.serratec.trabalho.service.PedidoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	
	@ApiOperation(value="Retorna todos os pedidos", notes="Pedido")
	@ApiResponses(value= {
	@ApiResponse(code=200, message="Retorna todos os pedidos"),
	@ApiResponse(code=401, message="Erro de autenticação"),
	@ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
	@ApiResponse(code=404, message="Recurso não encontrado"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
	@GetMapping
	public ResponseEntity<List<Pedido>> buscaTodos() {
		List<Pedido> pedidos = pedidoService.buscarTodos();
		return ResponseEntity.ok(pedidos);
	}
	
	@ApiOperation(value="Retorna um pedido por id", notes="Pedido")
	@ApiResponses(value= {
	@ApiResponse(code=200, message="Retorna uma pedido por id"),
	@ApiResponse(code=401, message="Erro de autenticação"),
	@ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
	@ApiResponse(code=404, message="Recurso não encontrado"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
	@GetMapping("/{id}")
	public ResponseEntity<Pedido> buscarPedido(@PathVariable Long id) throws DataPedidoException {
		Pedido pedido = pedidoService.buscaPorId(id);
		return ResponseEntity.ok(pedido);
	}
	
	@ApiOperation(value="Retorna todos os relatorios", notes="Pedido")
	@ApiResponses(value= {
	@ApiResponse(code=200, message="Retorna todos os relatorios"),
	@ApiResponse(code=401, message="Erro de autenticação"),
	@ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
	@ApiResponse(code=404, message="Recurso não encontrado"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
	@GetMapping("/relatorio")
	public ResponseEntity<List<RelatorioDTO>> listarRelatorio() {
		return ResponseEntity.ok(pedidoService.buscarTodosRelatorios());
	}
	
	@ApiOperation(value="Retorna um relatorio por id", notes="Pedido")
	@ApiResponses(value= {
	@ApiResponse(code=200, message="Retorna um relatorio por id"),
	@ApiResponse(code=401, message="Erro de autenticação"),
	@ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
	@ApiResponse(code=404, message="Recurso não encontrado"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
	@GetMapping("/relatorio/{id}")
	public ResponseEntity<RelatorioDTO> listarRelatorioPorId(@PathVariable Long id) throws DataPedidoException {
		RelatorioDTO relatorio = pedidoService.buscarRelatorioPorId(id);
		return ResponseEntity.ok(relatorio);
	}
	
	@ApiOperation(value="Insere um novo pedido", notes="Pedido")
	@ApiResponses(value= {
	@ApiResponse(code=201, message="Pedido inserido com sucesso"),
	@ApiResponse(code=401, message="Erro de autenticação"),
	@ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
	@ApiResponse(code=404, message="Recurso não encontrado"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
	@PostMapping
	public ResponseEntity<Pedido> inserir(@Valid @RequestBody PedidoInserirDTO pedidoInserirDTO)
			throws DataPedidoException {
		Pedido pedido = pedidoService.incluir(pedidoInserirDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pedido.getIdPedido())
				.toUri();
		return ResponseEntity.created(uri).body(pedido);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Pedido> atualizar(@PathVariable Long id, @Valid @RequestBody Pedido pedido)
			throws DataPedidoException {
		return ResponseEntity.ok(pedidoService.atualizar(id, pedido));
	}
	
	@ApiOperation(value="Exclui um pedido", notes="Pedido")
	@ApiResponses(value= {
	@ApiResponse(code=200, message="Pedido Removido"),
	@ApiResponse(code=401, message="Erro de autenticação"),
	@ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
	@ApiResponse(code=404, message="Recurso não encontrado"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) throws DataPedidoException {
		pedidoService.deletar(id);
		return ResponseEntity.noContent().build();
	}
}
