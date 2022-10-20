package br.org.serratec.trabalho.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.trabalho.domain.Categoria;
import br.org.serratec.trabalho.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public List<Categoria> buscarTodos() {
		return categoriaRepository.findAll();
	}

	public Categoria incluir(Categoria categoria) {
		categoria = categoriaRepository.save(categoria);
		return categoria;
	}

	public Categoria buscaPorId(Long id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		return categoria.get();
	}
}
