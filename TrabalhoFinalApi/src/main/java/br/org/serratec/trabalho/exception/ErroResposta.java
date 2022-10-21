package br.org.serratec.trabalho.exception;

import java.time.LocalDateTime;
import java.util.List;

public class ErroResposta {
	private Integer status;
	private String titulo;
	private LocalDateTime dataHora;
	private List<ErroCampo> erros;

	public ErroResposta(Integer status, String titulo, LocalDateTime dataHora, List<ErroCampo> erros) {
		super();
		this.status = status;
		this.titulo = titulo;
		this.dataHora = dataHora;
		this.erros = erros;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public List<ErroCampo> getErros() {
		return erros;
	}

	public void setErros(List<ErroCampo> erros) {
		this.erros = erros;
	}

}
