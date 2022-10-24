package br.org.serratec.trabalho.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import br.org.serratec.trabalho.dto.RelatorioDTO;

@Configuration
public class MailConfig {
	@Autowired
	private JavaMailSender javaMailSender;

	public void sendEmail(String para, RelatorioDTO relatorioDTO) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("taldapispagola@gmail.com");
		message.setTo(para);
		message.setSubject("Pedido Registrado!!!");
		message.setText("Relatório: \n\n" + relatorioDTO.toString());

		javaMailSender.send(message);
	}
}
