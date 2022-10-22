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
	private LocalDate data_pedidoInserida;

	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate data_entregaInserida;

	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate data_envioInserida;

	@NotBlank
	private String statusInserido;

	@NotNull
	private Cliente clienteInserido;

	private List<PedidoItenInseridoDTO> itensInseridos;

	public LocalDate getData_pedidoInserida() {
		return data_pedidoInserida;
	}

	public void setData_pedidoInserida(LocalDate data_pedidoInserida) {
		this.data_pedidoInserida = data_pedidoInserida;
	}

	public LocalDate getData_entregaInserida() {
		return data_entregaInserida;
	}

	public void setData_entregaInserida(LocalDate data_entregaInserida) {
		this.data_entregaInserida = data_entregaInserida;
	}

	public LocalDate getData_envioInserida() {
		return data_envioInserida;
	}

	public void setData_envioInserida(LocalDate data_envioInserida) {
		this.data_envioInserida = data_envioInserida;
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
