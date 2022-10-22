package br.org.serratec.trabalho.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.org.serratec.trabalho.domain.Cliente;

public class PedidoInserirDTO {
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataPedidoInserida;

	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataEntregaInserida;

	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataEnvioInserida;

	@NotBlank
	private String statusInserido;

	@NotNull
	private Cliente clienteInserido;

	private List<PedidoItenInseridoDTO> itensInseridos;

	public LocalDate getDataPedidoInserida() {
		return dataPedidoInserida;
	}

	public void setDataPedidoInserida(LocalDate dataPedidoInserida) {
		this.dataPedidoInserida = dataPedidoInserida;
	}

	public LocalDate getDataEntregaInserida() {
		return dataEntregaInserida;
	}

	public void setDataEntregaInserida(LocalDate dataEntregaInserida) {
		this.dataEntregaInserida = dataEntregaInserida;
	}

	public LocalDate getDataEnvioInserida() {
		return dataEnvioInserida;
	}

	public void setDataEnvioInserida(LocalDate dataEnvioInserida) {
		this.dataEnvioInserida = dataEnvioInserida;
	}

	public String getStatusInserido() {
		return statusInserido;
	}

	public void setStatusInserido(String statusInserido) {
		this.statusInserido = statusInserido;
	}

	public Cliente getClienteInserido() {
		return clienteInserido;
	}

	public void setClienteInserido(Cliente clienteInserido) {
		this.clienteInserido = clienteInserido;
	}

	public List<PedidoItenInseridoDTO> getItensInseridos() {
		return itensInseridos;
	}

	public void setItensInseridos(List<PedidoItenInseridoDTO> itensInseridos) {
		this.itensInseridos = itensInseridos;
	}

}
