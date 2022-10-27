package br.org.serratec.trabalho.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.org.serratec.trabalho.domain.Categoria;
import br.org.serratec.trabalho.domain.Produto;
import io.swagger.annotations.ApiModelProperty;

public class ProdutoDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value="Identificador unico de produto")
	private Long idProduto;

	@NotBlank
	@Column(name = "nome_produto", nullable = false, length = 30, unique = true)
	@ApiModelProperty(value="Nome do Produto", required = true)
	private String nomeProduto;

	@NotBlank
	@Column(name = "descricao_produto", length = 200)
	@ApiModelProperty(value="Descrição do Produto", required = true)
	private String descricaoProduto;

	@NotNull
	@Column(name = "qtd_estoque")
	@ApiModelProperty(value="Quantidade de estoque", required = true)
	private Integer quantidadeEstoque;

	@NotNull
	@Column(name = "data_cadastro")
	@JsonFormat(pattern = "dd/MM/yyyy")
	@ApiModelProperty(value="Data de cadastro", required = true)
	private LocalDate dataCadastro;

	@NotNull
	@Column(name = "valor_unitario", nullable = false)
	@ApiModelProperty(value="Valor Unitario", required = true)
	private Double valorUnitario;

	@ManyToOne(fetch = FetchType.EAGER)
	@NotNull
	@JoinColumn(name = "id_categoria", nullable = false)
	@ApiModelProperty(value="Categoria", required = true)
	private Categoria categoria;

	public ProdutoDTO(Produto produto) {
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

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
