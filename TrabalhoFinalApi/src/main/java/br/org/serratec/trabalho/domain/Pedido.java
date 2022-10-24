package br.org.serratec.trabalho.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private Long idPedido;

	@NotNull
	@Column(name = "data_pedido", nullable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataPedido;

	@NotNull
	@Column(name = "data_entrega")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataEntrega;

	@NotNull
	@Column(name = "data_envio")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataEnvio;

	@NotBlank
	@Column(name = "status", nullable = false, length = 1)
	private String status;

	@NotNull
	@Column(name = "valor_total", nullable = false)
	private Double valorTotal;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_cliente", nullable = false)
	private Cliente cliente;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_pedido")
	private List<PedidoIten> itens;

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public LocalDate getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(LocalDate dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<PedidoIten> getPedidoIten() {
		return itens;
	}

	public void setPedidoIten(List<PedidoIten> pedidoIten) {
		this.itens = pedidoIten;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPedido);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(idPedido, other.idPedido);
	}

}
