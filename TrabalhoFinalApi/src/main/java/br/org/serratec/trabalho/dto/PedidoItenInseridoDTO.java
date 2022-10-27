package br.org.serratec.trabalho.dto;

import javax.validation.constraints.NotNull;

import br.org.serratec.trabalho.domain.Produto;
import io.swagger.annotations.ApiModelProperty;

public class PedidoItenInseridoDTO {
	@NotNull
	@ApiModelProperty(value="Quantidade", required = true)
	private Integer quantidade;
	
	@NotNull
	@ApiModelProperty(value="Percentual de desconto", required = true)
	private Double percentualDesconto;
	
	@NotNull
	@ApiModelProperty(value="Produto", required = true)
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
