package br.org.serratec.trabalho.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.trabalho.domain.Produto;
import br.org.serratec.trabalho.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<Produto> buscarTodos() {
		return produtoRepository.findAll();
	}

	public Produto incluir(Produto produto) {
		produto = produtoRepository.save(produto);
		return produto;
	}

	public Produto buscaPorId(Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		return produto.get();
	}

//	public Produto alterar(Long id, Produto produto) {
//		Optional<Produto> produtoBanco = produtoRepository.findById(id);
//		
//		if(produtoBanco.isEmpty()) {
//			throw new 
//		}
//
//	}

}
