package br.org.serratec.trabalho.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.trabalho.config.MailConfig;
import br.org.serratec.trabalho.domain.Cliente;
import br.org.serratec.trabalho.domain.Pedido;
import br.org.serratec.trabalho.domain.PedidoIten;
import br.org.serratec.trabalho.domain.Produto;
import br.org.serratec.trabalho.dto.PedidoInserirDTO;
import br.org.serratec.trabalho.dto.PedidoItenInseridoDTO;
import br.org.serratec.trabalho.dto.RelatorioDTO;
import br.org.serratec.trabalho.dto.RelatorioDePedidoDTO;
import br.org.serratec.trabalho.exception.DataNotFoundException;
import br.org.serratec.trabalho.exception.DataPedidoException;
import br.org.serratec.trabalho.repository.ClienteRepository;
import br.org.serratec.trabalho.repository.PedidoRepository;
import br.org.serratec.trabalho.repository.ProdutoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private MailConfig mailConfig;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	public List<Pedido> buscarTodos() {
		return pedidoRepository.findAll();
	}

	public Pedido buscaPorId(Long id) throws DataPedidoException {
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		if (!pedido.isPresent()) {
			throw new DataNotFoundException("O pedido com o id:" + id + " não foi encontrado");
		}
		return pedido.get();
	}

	public List<RelatorioDTO> buscarTodosRelatorios() {

		List<Pedido> pedidos = pedidoRepository.findAll();

		List<RelatorioDTO> relatorioDTO = new ArrayList<>();

		for (Pedido pedido : pedidos) {
			relatorioDTO.add(new RelatorioDTO(pedido));
		}

		return relatorioDTO;
	}

	public RelatorioDTO buscarRelatorioPorId(Long id) throws DataPedidoException {

		Optional<Pedido> pedido = pedidoRepository.findById(id);

		if (!pedido.isPresent()) {
			throw new DataNotFoundException("O pedido com o id:" + id + " não foi encontrado");
		}

		Pedido pedidoE = pedido.get();

		RelatorioDTO relatorioDTO = new RelatorioDTO(pedidoE);

		return relatorioDTO;
	}

	public Pedido incluir(PedidoInserirDTO pedidoInserirDTO) throws DataPedidoException {
		if (pedidoInserirDTO.getDataPedidoInserida().isBefore(LocalDate.now())) {
			throw new DataPedidoException();
		}

		Pedido pedido = new Pedido();

		List<PedidoIten> lista = new ArrayList<>();

		List<RelatorioDePedidoDTO> listaDTO = new ArrayList<>();

		Double valorTotal = 0.0;

		for (PedidoItenInseridoDTO pedidoItenInserir : pedidoInserirDTO.getItensInseridos()) {

			PedidoIten pedidoiten = new PedidoIten();

			Long id = pedidoItenInserir.getProduto().getIdProduto();

			Optional<Produto> produto = produtoRepository.findById(id);
			if (!produto.isPresent()) {
				throw new DataNotFoundException("O produto com o id:" + id + " não foi encontrado");
			}

			Produto produtoBanco = produto.get();

			Double precoVenda = produtoBanco.getValorUnitario();

			Integer qtde = pedidoItenInserir.getQuantidade();
			Double percentualDeconto = pedidoItenInserir.getPercentualDesconto();

			Double valorBruto = (precoVenda * qtde);
			Double valorDesconto = ((percentualDeconto / 100) * precoVenda);
			Double valorLiquido = (valorBruto - valorDesconto);

			pedidoiten.setQuantidade(qtde);
			pedidoiten.setPrecoVenda(precoVenda);
			pedidoiten.setPercentualDesconto(percentualDeconto);
			pedidoiten.setValorBruto(valorBruto);
			pedidoiten.setPercentualDesconto(valorDesconto);
			pedidoiten.setValorLiquido(valorLiquido);
			pedidoiten.setProduto(produtoBanco);

			valorTotal = valorTotal + valorLiquido;

			pedidoiten.setPedido(pedido);

			RelatorioDePedidoDTO relatorioDTO2 = new RelatorioDePedidoDTO(pedidoiten);

			listaDTO.add(relatorioDTO2);

			lista.add(pedidoiten);
		}

		pedido.setDataPedido(pedidoInserirDTO.getDataPedidoInserida());
		pedido.setDataEntrega(pedidoInserirDTO.getDataEntregaInserida());
		pedido.setDataEnvio(pedidoInserirDTO.getDataEnvioInserida());
		pedido.setStatus(pedidoInserirDTO.getStatusInserido());
		pedido.setValorTotal(valorTotal);
		pedido.setPedidoIten(lista);
		pedido.setCliente(pedidoInserirDTO.getClienteInserido());

		pedido = pedidoRepository.save(pedido);

		RelatorioDTO relatorioDTO = new RelatorioDTO(pedido, listaDTO);

		Long idCliente = pedidoInserirDTO.getClienteInserido().getIdCliente();

		Optional<Cliente> cliente = clienteRepository.findById(idCliente);
		if (!cliente.isPresent()) {
			throw new DataNotFoundException("O cliente com o id:" + idCliente + " não foi encontrado");
		}

		Cliente clienteBanco = cliente.get();

		String emailCliente = clienteBanco.getEmail();

		mailConfig.sendEmail(emailCliente, relatorioDTO);

		return pedido;
	}

	public Pedido atualizar(Long id, Pedido pedidoI) throws DataPedidoException {
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		if (!pedido.isPresent()) {
			throw new DataNotFoundException("O pedido com o id:" + id + " não foi encontrado");
		}
		Pedido pedidoBanco = pedido.get();

		pedidoBanco.setDataPedido(pedidoI.getDataPedido());
		pedidoBanco.setDataEntrega(pedidoI.getDataEntrega());
		pedidoBanco.setDataEnvio(pedidoI.getDataEnvio());
		pedidoBanco.setStatus(pedidoI.getStatus());
		pedidoBanco.setCliente(pedidoI.getCliente());

		return pedidoBanco;
	}

	public void deletar(Long id) throws DataPedidoException {
		Optional<Pedido> produtoBanco = pedidoRepository.findById(id);
		if (!produtoBanco.isPresent()) {
			throw new DataNotFoundException("O produto com o id:" + id + " não foi encontrado");
		}
		pedidoRepository.deleteById(id);
	}
}
