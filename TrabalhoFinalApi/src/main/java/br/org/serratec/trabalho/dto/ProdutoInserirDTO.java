package br.org.serratec.trabalho.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.org.serratec.trabalho.domain.Categoria;

public class ProdutoInserirDTO {
	@NotBlank
	private String nomeInserido;
	@NotBlank
	private String descricaoInserida;
	@NotNull
	private Integer qtdEstoqueInserida;
	@NotNull
	private Double valorUnitarioInserido;
	@NotNull
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
