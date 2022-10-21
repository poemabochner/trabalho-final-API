package br.org.serratec.trabalho.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.org.serratec.trabalho.domain.Produto;
import br.org.serratec.trabalho.repository.ProdutoRepository;
import br.org.serratec.trabalho.service.ProdutoService;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private ProdutoRepository produtoRepository;

	@GetMapping
	public ResponseEntity<List<Produto>> buscaTodos() {
		List<Produto> produtos = produtoService.buscarTodos();
		return ResponseEntity.ok(produtos);
	}

	@PostMapping
	public ResponseEntity<Produto> inserir(@Valid @RequestBody Produto produto) {
		produto = produtoService.incluir(produto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(produto.getIdProduto())
				.toUri();
		return ResponseEntity.created(uri).body(produto);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> buscarProduto(@PathVariable Long id) {
		Produto produto = produtoService.buscaPorId(id);
		return ResponseEntity.ok(produto);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Produto> atualizar(@PathVariable Long id, @Valid @RequestBody Produto produto) {

		return ResponseEntity.ok(produto);
	}

//	@DeleteMapping("/{id}")
//	public ResponseEntity<Void> excluir(@PathVariable Long id) {
//		Optional<Produto> produtoBanco = produtoRepository.findById(id);
//		if (!produtoBanco.isPresent()) {
//			return ResponseEntity.notFound().build();
//		}
//		produtoRepository.deleteById(id);
//		return ResponseEntity.noContent().build();
//	}

}
