package br.org.serratec.trabalho.dto;

import br.org.serratec.trabalho.domain.Categoria;

public class ProdutoInserirDTO {
	private String nomeInserido;
	private String descricaoInserida;
	private Integer qtdEstoqueInserida;
	private Double valorUnitarioInserido;
	private Categoria categoriaInserida;

	public String getNomeInserido() {
		return nomeInserido;
	}

	public void setNomeInserido(String nomeInserido) {
		this.nomeInserido = nomeInserido;
	}

	public String getDescricaoInserida() {
		return descricaoInserida;
	}

	public void setDescricaoInserida(String descricaoInserida) {
		this.descricaoInserida = descricaoInserida;
	}

	public Integer getQtdEstoqueInserida() {
		return qtdEstoqueInserida;
	}

	public void setQtdEstoqueInserida(Integer qtdEstoqueInserida) {
		this.qtdEstoqueInserida = qtdEstoqueInserida;
	}

	public Double getValorUnitarioInserido() {
		return valorUnitarioInserido;
	}

	public void setValorUnitarioInserido(Double valorUnitarioInserido) {
		this.valorUnitarioInserido = valorUnitarioInserido;
	}

	public Categoria getCategoriaInserida() {
		return categoriaInserida;
	}

	public void setCategoriaInserida(Categoria categoriaInserida) {
		this.categoriaInserida = categoriaInserida;
	}

}
