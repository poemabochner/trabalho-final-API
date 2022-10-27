package br.org.serratec.trabalho.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.org.serratec.trabalho.domain.Categoria;
import io.swagger.annotations.ApiModelProperty;

public class ProdutoInserirDTO {
	@NotBlank
	@ApiModelProperty(value="Nome do produto", required = true)
	private String nomeInserido;
	
	@NotBlank
	@ApiModelProperty(value="Descrição do produto", required = true)
	private String descricaoInserida;
	
	@NotNull
	@ApiModelProperty(value="Quantidade no Estosque", required = true)
	private Integer qtdEstoqueInserida
	;
	@NotNull
	@ApiModelProperty(value="Valor unitario do produto", required = true)
	private Double valorUnitarioInserido;
	
	@NotNull
	@ApiModelProperty(value="Categoria", required = true)
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
