package br.org.serratec.trabalho.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.trabalho.domain.Produto;
import br.org.serratec.trabalho.dto.ProdutoInserirDTO;
import br.org.serratec.trabalho.exception.DataNotFoundException;
import br.org.serratec.trabalho.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<Produto> buscarTodos() {
		return produtoRepository.findAll();
	}

	public Produto buscaPorId(Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		return produto.get();
	}

	public Produto incluir(ProdutoInserirDTO produtoInserirDTO) {

		Produto produto = new Produto();

		produto.setNomeProduto(produtoInserirDTO.getNomeInserido());
		produto.setDescricaoProduto(produtoInserirDTO.getDescricaoInserida());
		produto.setQuantidadeEstoque(produtoInserirDTO.getQtdEstoqueInserida());
		produto.setValorUnitario(produtoInserirDTO.getValorUnitarioInserido());
		produto.setCategoria(produtoInserirDTO.getCategoriaInserida());
		produto.setDataCadastro(LocalDate.now());

		produto = produtoRepository.save(produto);
		return produto;
	}

	public Produto alterar(Long id, Produto produto) throws DataNotFoundException {
		Optional<Produto> produtoBanco = produtoRepository.findById(id);
		if (!produtoBanco.isPresent()) {
//			return ResponseEntity.notFound().build();
			throw new DataNotFoundException("O produto com o id:" + id + " não foi encontrado");
			// TODO LANÇAR A exception 404
		}

		produto.setIdProduto(id);
		produto = produtoRepository.save(produto);
		return produto;
	}

}
