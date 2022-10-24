package br.org.serratec.trabalho.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.org.serratec.trabalho.domain.Produto;
import br.org.serratec.trabalho.dto.ProdutoDTO;
import br.org.serratec.trabalho.dto.ProdutoInserirDTO;
import br.org.serratec.trabalho.exception.DataNotFoundException;
import br.org.serratec.trabalho.exception.DescricaoException;
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
		if (!produto.isPresent()) {
			throw new DataNotFoundException("O produto com o id:" + id + " não foi encontrado");
		}
		return produto.get();
	}

	public ProdutoDTO incluir(ProdutoInserirDTO produtoInserirDTO, MultipartFile file) throws IOException {
		Optional<Produto> produtoOptional = produtoRepository
				.findByDescricaoProduto(produtoInserirDTO.getDescricaoInserida());

		if (produtoOptional.isPresent()) {
			throw new DescricaoException(
					"Já existe um produto com está descrição: " + produtoInserirDTO.getDescricaoInserida());
		}

		Produto produto = new Produto();

		produto.setNomeProduto(produtoInserirDTO.getNomeInserido());
		produto.setDescricaoProduto(produtoInserirDTO.getDescricaoInserida());
		produto.setQuantidadeEstoque(produtoInserirDTO.getQtdEstoqueInserida());
		produto.setValorUnitario(produtoInserirDTO.getValorUnitarioInserido());
		produto.setCategoria(produtoInserirDTO.getCategoriaInserida());
		produto.setDataCadastro(LocalDate.now());
		produto.setTipoArquivo(file.getContentType());
		produto.setImagem(file.getBytes());
		produto = produtoRepository.save(produto);
		return new ProdutoDTO(produto);
	}

	public Produto alterar(Long id, Produto produto) throws DataNotFoundException {
		Optional<Produto> produtoOptional = produtoRepository.findById(id);
		Optional<Produto> produtoOptional2 = produtoRepository.findByDescricaoProduto(produto.getDescricaoProduto());

		Produto produtoBanco2 = produtoOptional2.get();

		if (!produtoOptional.isPresent()) {
			throw new DataNotFoundException("O produto com o id:" + id + " não foi encontrado");
		}
		if (produtoBanco2.getDescricaoProduto().equals(produto.getDescricaoProduto())) {
			throw new DescricaoException("Já existe um produto com está descrição: " + produto.getDescricaoProduto());
		}

		Produto produtoBanco = produtoOptional.get();

		produtoBanco.setNomeProduto(produto.getNomeProduto());
		produtoBanco.setDescricaoProduto(produto.getDescricaoProduto());
		produtoBanco.setQuantidadeEstoque(produto.getQuantidadeEstoque());
		produtoBanco.setDataCadastro(produto.getDataCadastro());
		produtoBanco.setValorUnitario(produto.getValorUnitario());
		produtoBanco.setCategoria(produto.getCategoria());

		produtoBanco = produtoRepository.save(produtoBanco);
		return produtoBanco;
	}

	public void deletar(Long id) {
		Optional<Produto> produtoBanco = produtoRepository.findById(id);
		if (!produtoBanco.isPresent()) {
			throw new DataNotFoundException("O produto com o id:" + id + " não foi encontrado");
		}
		produtoRepository.deleteById(id);
	}

}
