package br.org.serratec.trabalho.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.trabalho.domain.Cliente;
import br.org.serratec.trabalho.exception.CPFException;
import br.org.serratec.trabalho.exception.EmailException;
import br.org.serratec.trabalho.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public List<Cliente> buscarTodos() {
		return clienteRepository.findAll();
	}

	public Cliente incluir(Cliente cliente) throws EmailException, CPFException {
		Cliente clienteBanco = clienteRepository.findByEmail(cliente.getEmail());

		Cliente clienteBancoo = clienteRepository.findByCpf(cliente.getCpf());

		if (clienteBanco != null) {
			throw new EmailException("Já existe um cliente com o email " + cliente.getEmail());
		}
		if (clienteBancoo != null) {
			throw new CPFException("Já existe um cliente com o CPF " + cliente.getCpf());
		}

		cliente = clienteRepository.save(cliente);
		return cliente;
	}

	public Cliente buscaPorId(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.get();
	}
}
