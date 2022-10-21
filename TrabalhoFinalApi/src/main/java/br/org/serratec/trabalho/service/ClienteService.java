package br.org.serratec.trabalho.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.trabalho.domain.Cliente;
import br.org.serratec.trabalho.domain.Endereco;
import br.org.serratec.trabalho.dto.ClienteInserirDTO;
import br.org.serratec.trabalho.exception.CPFException;
import br.org.serratec.trabalho.exception.EmailException;
import br.org.serratec.trabalho.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoService enderecoService;

	public List<Cliente> buscarTodos() {
		return clienteRepository.findAll();
	}

	public Cliente buscaPorId(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.get();
	}

	public Cliente incluir(ClienteInserirDTO clienteInserirDTO) throws EmailException, CPFException {
		Cliente clienteBanco = clienteRepository.findByEmail(clienteInserirDTO.getEmail());

		Cliente clienteBancoo = clienteRepository.findByCpf(clienteInserirDTO.getCpf());

		if (clienteBanco != null) {
			throw new EmailException("Já existe um cliente com o email " + clienteInserirDTO.getEmail());
		}
		if (clienteBancoo != null) {
			throw new CPFException("Já existe um cliente com o CPF " + clienteInserirDTO.getCpf());
		}
		Endereco enderecoNovo = new Endereco();

		enderecoNovo = enderecoService.buscarCep(clienteInserirDTO.getCepInserido());
		enderecoNovo.setNumero(clienteInserirDTO.getNumeroInserido());

		Cliente cliente = new Cliente();

		cliente.setNomeCompleto(clienteInserirDTO.getNomeCompleto());
		cliente.setEmail(clienteInserirDTO.getEmail());
		cliente.setCpf(clienteInserirDTO.getCpf());
		cliente.setTelefone(clienteInserirDTO.getTelefone());
		cliente.setDataNascimento(clienteInserirDTO.getDataNascimento());
		cliente.setEndereco(enderecoNovo);

		cliente = clienteRepository.save(cliente);
		return cliente;
	}

}
