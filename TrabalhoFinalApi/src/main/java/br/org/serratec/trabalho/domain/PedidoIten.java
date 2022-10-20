package br.org.serratec.trabalho.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "item_pedido")
public class PedidoIten {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPedidoIten;

	@NotNull
	@Column(name = "quantidade", nullable = false)
	private Integer quantidade;

	@NotNull
	@Column(name = "preco_venda", nullable = false)
	private Double preco_venda;

	@NotNull
	@Column(name = "percentual_desconto", nullable = false)
	private Double percentual_desconto;

	@NotNull
	@Column(name = "valor_bruto", nullable = false)
	private Double valor_bruto;

	@NotNull
	@Column(name = "valor_liquido", nullable = false)
	private Double valor_liquido;

	@ManyToOne
	@NotNull
	@JoinColumn(name = "id_produto")
	private Produto produto;

	public Long getIdPedidoIten() {
		return idPedidoIten;
	}

	public void setIdPedidoIten(Long idPedidoIten) {
		this.idPedidoIten = idPedidoIten;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco_venda() {
		return preco_venda;
	}

	public void setPreco_venda(Double preco_venda) {
		this.preco_venda = preco_venda;
	}

	public Double getPercentual_desconto() {
		return percentual_desconto;
	}

	public void setPercentual_desconto(Double percentual_desconto) {
		this.percentual_desconto = percentual_desconto;
	}

	public Double getValor_bruto() {
		return valor_bruto;
	}

	public void setValor_bruto(Double valor_bruto) {
		this.valor_bruto = valor_bruto;
	}

	public Double getValor_liquido() {
		return valor_liquido;
	}

	public void setValor_liquido(Double valor_liquido) {
		this.valor_liquido = valor_liquido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPedidoIten);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoIten other = (PedidoIten) obj;
		return Objects.equals(idPedidoIten, other.idPedidoIten);
	}

}
