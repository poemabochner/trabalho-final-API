package br.org.serratec.trabalho.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.org.serratec.trabalho.domain.Cliente;
import io.swagger.annotations.ApiModelProperty;

public class PedidoInserirDTO {
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
	@ApiModelProperty(value="Data do pedido", required = true)
	private LocalDate dataPedidoInserida;

	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
	@ApiModelProperty(value="Data do entrega", required = true)
	private LocalDate dataEntregaInserida;

	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
	@ApiModelProperty(value="Data do envio", required = true)
	private LocalDate dataEnvioInserida;

	@NotBlank
	@ApiModelProperty(value="Status do pedido", required = true)
	private String statusInserido;

	@NotNull
	@ApiModelProperty(value="Cliente", required = true)
	private Cliente clienteInserido;
	
	@ApiModelProperty(value="Items do pedido")
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
