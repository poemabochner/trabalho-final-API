package br.org.serratec.trabalho.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EmailException.class)
	public ResponseEntity<Object> handlerEmailException(EmailException ex) {
		return ResponseEntity.unprocessableEntity().body(ex.getMessage());
	}

	@ExceptionHandler(CPFException.class)
	public ResponseEntity<Object> handlerCpfException(CPFException ex) {
		return ResponseEntity.unprocessableEntity().body(ex.getMessage());
	}

	@ExceptionHandler(DescricaoException.class)
	public ResponseEntity<Object> handlerDescricaoException(DescricaoException ex) {
		return ResponseEntity.unprocessableEntity().body(ex.getMessage());
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<ErroCampo> erros = new ArrayList<>();
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			erros.add(new ErroCampo(error.getField(), error.getDefaultMessage()));
		}
		ErroResposta erroResposta = new ErroResposta(status.value(), "Existem Campos Inválidos", LocalDateTime.now(),
				erros);
		return super.handleExceptionInternal(ex, erroResposta, headers, status, request);
	}

	@ExceptionHandler(DataPedidoException.class)
	public ResponseEntity<Object> handleDataEmprestimoAnteriorException(DataPedidoException ex) {
		List<ErroCampo> erros = new ArrayList<>();
		erros.add(new ErroCampo("dataPedido", "Data do pedido não pode ser anterior a data de hoje."));

		ErroResposta erroResposta = new ErroResposta(HttpStatus.BAD_REQUEST.value(), "Existem Campos Inválidos",
				LocalDateTime.now(), erros);
		return ResponseEntity.badRequest().body(erroResposta);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return ResponseEntity.badRequest().body(ex.getMessage());
	}

	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<Object> DataNotFoundException(DataNotFoundException ex) {
		return ((BodyBuilder) ResponseEntity.notFound()).body(ex.getMessage());
	}

}
