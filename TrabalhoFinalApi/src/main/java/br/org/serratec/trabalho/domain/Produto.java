package br.org.serratec.trabalho.domain;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "produto")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value="Identificador unico de produto")
	private Long idProduto;

	@NotBlank
	@Column(name = "nome_produto", nullable = false, length = 30, unique = true)
	@ApiModelProperty(value="Nome do produto", required = true)
	private String nomeProduto;

	@NotBlank
	@Column(name = "descricao_produto", length = 200)
	@ApiModelProperty(value="Descrição do produto", required = true)
	private String descricaoProduto;

	@NotNull
	@Column(name = "qtd_estoque")
	@ApiModelProperty(value="Quantidade no estoque", required = true)
	private Integer quantidadeEstoque;

	@NotNull
	@Column(name = "data_cadastro")
	@JsonFormat(pattern = "dd/MM/yyyy")
	@ApiModelProperty(value="Data de cadastro", required = true)
	private LocalDate dataCadastro;

	@NotNull
	@Column(name = "valor_unitario", nullable = false)
	@ApiModelProperty(value="Valor unitario do produto", required = true)
	private Double valorUnitario;

	@JsonIgnore
	@Lob
	@Type(type = "org.hibernate.type.BinaryType")
	@Column(name = "imagem", nullable = false)
	@ApiModelProperty(value="dados da imagem", required = true)
	private byte[] imagem;

	@JsonIgnore
	@NotBlank
	@Column(name = "tipo_arquivo", length = 100)
	@ApiModelProperty(value="Tipo de arquivo da imagem", required = true)
	private String tipoArquivo;

	@ManyToOne(fetch = FetchType.EAGER)
	@NotNull
	@JoinColumn(name = "id_categoria", nullable = false)
	@ApiModelProperty(value="Catgoria")
	private Categoria categoria;

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

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public String getTipoArquivo() {
		return tipoArquivo;
	}

	public void setTipoArquivo(String tipoArquivo) {
		this.tipoArquivo = tipoArquivo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idProduto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(idProduto, other.idProduto);
	}

}
