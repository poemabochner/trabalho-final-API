package br.org.serratec.trabalho.dto;

import javax.validation.constraints.NotNull;

import br.org.serratec.trabalho.domain.Produto;

public class PedidoItenInseridoDTO {
	@NotNull
	private Integer quantidade;
	@NotNull
	private Double percentualDesconto;
	@NotNull
	private Produto produto;

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPercentualDesconto() {
		return percentualDesconto;
	}

	public void setPercentualDesconto(Double percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
