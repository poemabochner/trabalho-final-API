package br.org.serratec.trabalho.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.trabalho.domain.Categoria;
import br.org.serratec.trabalho.exception.DataNotFoundException;
import br.org.serratec.trabalho.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public List<Categoria> buscarTodos() {
		return categoriaRepository.findAll();
	}

	public Categoria buscaPorId(Long id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		if (!categoria.isPresent()) {
			throw new DataNotFoundException("O produto com o id:" + id + " não foi encontrado");
		}
		return categoria.get();
	}

	public Categoria incluir(Categoria categoria) {
		categoria = categoriaRepository.save(categoria);
		return categoria;
	}

	public Categoria alterar(Long id, Categoria categoria) throws DataNotFoundException {
		Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);
		if (!categoriaOptional.isPresent()) {
			throw new DataNotFoundException("O categoria com o id:" + id + " não foi encontrado");
		}
		Categoria categoriaBanco = categoriaOptional.get();

		categoriaBanco.setNomeCategoria(categoria.getNomeCategoria());
		categoriaBanco.setDescricaoCategoria(categoria.getDescricaoCategoria());

		categoriaBanco = categoriaRepository.save(categoriaBanco);
		return categoriaBanco;
	}

	public void deletar(Long id) {
		Optional<Categoria> produtoBanco = categoriaRepository.findById(id);
		if (!produtoBanco.isPresent()) {
			throw new DataNotFoundException("O produto com o id:" + id + " não foi encontrado");
		}
		categoriaRepository.deleteById(id);
	}

}
