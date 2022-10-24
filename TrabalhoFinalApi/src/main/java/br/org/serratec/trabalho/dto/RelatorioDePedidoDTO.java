package br.org.serratec.trabalho.dto;

import br.org.serratec.trabalho.domain.PedidoIten;

public class RelatorioDePedidoDTO {

	private Long idProduto;

	private String nomeProduto;
	private Integer qunatidade;
	private Double precoVenda;
	private Double valorBruto;
	private Double percentualDesconto;
	private Double valorLiquido;

	public RelatorioDePedidoDTO() {
		super();
	}

	public RelatorioDePedidoDTO(PedidoIten pedidoIten) {
		super();
		this.idProduto = pedidoIten.getProduto().getIdProduto();
		this.nomeProduto = pedidoIten.getProduto().getNomeProduto();
		this.qunatidade = pedidoIten.getQuantidade();
		this.precoVenda = pedidoIten.getPrecoVenda();
		this.valorBruto = pedidoIten.getValorBruto();
		this.percentualDesconto = pedidoIten.getPercentualDesconto();
		this.valorLiquido = pedidoIten.getValorLiquido();
	}

	@Override
	public String toString() {
		return "\tId Do Produto: " + idProduto + "\n \tNome Do Produto: " + nomeProduto + "\n\t Quantidade: "
				+ qunatidade + "\n\t Preco De Venda: " + precoVenda + "\n\t Valor Bruto: " + valorBruto
				+ "\n\t Percentual De Desconto: " + percentualDesconto + "\n\t Valor Liquido: " + valorLiquido;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Integer getQunatidade() {
		return qunatidade;
	}

	public void setQunatidade(Integer qunatidade) {
		this.qunatidade = qunatidade;
	}

	public Double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public Double getValorBruto() {
		return valorBruto;
	}

	public void setValorBruto(Double valorBruto) {
		this.valorBruto = valorBruto;
	}

	public Double getPercentualDesconto() {
		return percentualDesconto;
	}

	public void setPercentualDesconto(Double percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}

	public Double getValorLiquido() {
		return valorLiquido;
	}

	public void setValorLiquido(Double valorLiquido) {
		this.valorLiquido = valorLiquido;
	}

}
