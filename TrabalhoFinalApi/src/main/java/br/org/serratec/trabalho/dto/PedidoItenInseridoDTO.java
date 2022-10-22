package br.org.serratec.trabalho.dto;

import javax.validation.constraints.NotNull;

import br.org.serratec.trabalho.domain.Produto;

public class PedidoItenInseridoDTO {
	@NotNull
	private Integer quantidade;
	@NotNull
	private Double percentual_desconto;
	@NotNull
	private Produto produto;
}
