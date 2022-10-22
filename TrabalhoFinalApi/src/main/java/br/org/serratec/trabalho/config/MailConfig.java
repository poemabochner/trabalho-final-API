package br.org.serratec.trabalho.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class MailConfig {
	@Autowired
	private JavaMailSender javaMailSender;

	public void sendEmail(String para, String assunto, String texto) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("poemabochner8@gmail.com");
		message.setTo(para);
		message.setSubject(assunto);
		message.setText("Dados da inscrição: \n" + texto + "\n\n\nSerratec Residência de Software");
		javaMailSender.send(message);
	}
}
