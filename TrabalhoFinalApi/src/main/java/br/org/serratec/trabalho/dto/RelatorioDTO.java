package br.org.serratec.trabalho.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.org.serratec.trabalho.domain.Pedido;
import br.org.serratec.trabalho.domain.PedidoIten;

public class RelatorioDTO {

	private Long idPedido;

	private LocalDate dataPeddo;

	private Double valorTotal;

	private List<RelatorioDePedidoDTO> itens;

	public RelatorioDTO(Pedido pedido) {
		super();
		this.idPedido = pedido.getIdPedido();
		this.dataPeddo = pedido.getDataPedido();
		this.valorTotal = pedido.getValorTotal();
		this.itens = new ArrayList<>();
		for (PedidoIten iten : pedido.getPedidoIten()) {
			this.itens.add(new RelatorioDePedidoDTO(iten));
		}
	}

	public RelatorioDTO(Long idPedido, LocalDate dataPeddo, Double valorTotal, List<RelatorioDePedidoDTO> itens) {
		super();
		this.idPedido = idPedido;
		this.dataPeddo = dataPeddo;
		this.valorTotal = valorTotal;
		this.itens = itens;
	}

	public RelatorioDTO(Pedido pedido, List<RelatorioDePedidoDTO> relatorioDePedidoDTO) {
		super();
		this.idPedido = pedido.getIdPedido();
		this.dataPeddo = pedido.getDataPedido();
		this.valorTotal = pedido.getValorTotal();
		this.itens = relatorioDePedidoDTO;
	}

	@Override
	public String toString() {
		return "Id do Pedido: " + idPedido + "\nData do Pedido: " + dataPeddo + "\n Valor Total: " + valorTotal
				+ "\n Itens: \n\n" + itens.toString();
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public LocalDate getDataPeddo() {
		return dataPeddo;
	}

	public void setDataPeddo(LocalDate dataPeddo) {
		this.dataPeddo = dataPeddo;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<RelatorioDePedidoDTO> getItens() {
		return itens;
	}

	public void setItens(List<RelatorioDePedidoDTO> itens) {
		this.itens = itens;
	}

}
