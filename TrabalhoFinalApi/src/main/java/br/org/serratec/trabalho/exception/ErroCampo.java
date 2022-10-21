package br.org.serratec.trabalho.exception;

public class ErroCampo {
	private String campo;
	private String mensagem;

	public ErroCampo(String campo, String mensagem) {
		super();
		this.campo = campo;
		this.mensagem = mensagem;
	}

	public String getCampo() {
		return campo;
	}

	public String getMensagem() {
		return mensagem;
	}
}
