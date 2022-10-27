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

import br.org.serratec.trabalho.domain.Categoria;
import br.org.serratec.trabalho.service.CategoriaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	@ApiOperation(value="Retorna todas as categorias", notes="Categoria")
	@ApiResponses(value= {
	@ApiResponse(code=200, message="Retorna todas as categorias"),
	@ApiResponse(code=401, message="Erro de autenticação"),
	@ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
	@ApiResponse(code=404, message="Recurso não encontrado"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
	@GetMapping
	public ResponseEntity<List<Categoria>> buscaTodos() {
		List<Categoria> categorias = categoriaService.buscarTodos();
		return ResponseEntity.ok(categorias);
	}
	
	@ApiOperation(value="Retorna uma categoria por id ", notes="Categoria")
	@ApiResponses(value= {
	@ApiResponse(code=200, message="Retorna uma categoria por id"),
	@ApiResponse(code=401, message="Erro de autenticação"),
	@ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
	@ApiResponse(code=404, message="Recurso não encontrado"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> buscarCategoria(@PathVariable Long id) {
		Categoria categoria = categoriaService.buscaPorId(id);
		return ResponseEntity.ok(categoria);
	}
	
	@ApiOperation(value="Insere uma nova categoria", notes="Categoria")
	@ApiResponses(value= {
	@ApiResponse(code=201, message="Categoria inserida com sucesso"),
	@ApiResponse(code=401, message="Erro de autenticação"),
	@ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
	@ApiResponse(code=404, message="Recurso não encontrado"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
	@PostMapping
	public ResponseEntity<Categoria> inserir(@Valid @RequestBody Categoria categoria) {
		categoria = categoriaService.incluir(categoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(categoria.getIdCategoria()).toUri();
		return ResponseEntity.created(uri).body(categoria);
	}
	
	@ApiOperation(value="Atualiza dados de uma categoria", notes="Atualizar Categoria")
	@ApiResponses(value= {
	@ApiResponse(code=200, message="Categoria Atualizado"),
	@ApiResponse(code=201, message="Categoria Atualizado"),
	@ApiResponse(code=401, message="Erro de autenticação"),
	@ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
	@ApiResponse(code=404, message="Recurso não encontrado"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
	@PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizar(@PathVariable Long id, @Valid @RequestBody Categoria categoria) {
        return ResponseEntity.ok(categoriaService.alterar(id, categoria));
    }
	
	@ApiOperation(value="Exclui uma categoria", notes="Categoria")
	@ApiResponses(value= {
	@ApiResponse(code=200, message="Categoria Removida"),
	@ApiResponse(code=401, message="Erro de autenticação"),
	@ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
	@ApiResponse(code=404, message="Recurso não encontrado"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		categoriaService.deletar(id);
		return ResponseEntity.noContent().build();
	}
}
