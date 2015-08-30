package escola.musica.servico.impl;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import escola.musica.modelo.UsuarioProfessor;
import escola.musica.servico.EnvioEmailServico;

@Service
public class EnvioEmailServicoImpl implements EnvioEmailServico{

	@Override
	public void enviarEmail(String assunto, String texto, 
			List<File> anexos, String... destinatarios) {
		//http://www.mballem.com/post/enviando-email-com-a-api-javamail/
		
		try {
			JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
			mailSender.setHost("smtp.gmail.com");
			mailSender.setPort(587);
			mailSender.setProtocol("smtp");
			mailSender.setUsername("heitor.instrutor.season@gmail.com");
			mailSender.setPassword("academiaweb2014");
			mailSender.setDefaultEncoding("utf-8");
			
			Properties properties = new Properties();
			properties.setProperty("username", "heitor.instrutor.season@gmail.com");
			properties.setProperty("password", "academiaweb2014");
			properties.setProperty("mail.smtp.auth", "true");
			properties.setProperty("mail.smtp.starttls.enable", "true");
			properties.setProperty("mail.transport.protocol", "smtp");
			mailSender.setJavaMailProperties(properties);
			
			MimeMessage msg = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(msg, false);
			helper.setFrom("heitor.instrutor.season@gmail.com");
			helper.setSubject(assunto);
			helper.setText(texto, true);
			//helper.addTo("heitor.albano1984@gmail.com");
			
			for (String destinatario : destinatarios) {
				helper.addTo(destinatario);
			}
			
			mailSender.send(msg);
			
			System.out.println("Enviando email..."); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	@Async
	public void enviarEmailCadastroUsuarioProfessor(UsuarioProfessor usuarioProfessor, String senha) {
		String assunto = "Cadastro de Usuário";
		String texto = pegarHtmlEmail(
				"resources/email_cadastro_usuario_professor.html");
		
		texto = texto.replace("{professor.nome}", usuarioProfessor.getNome());
		texto = texto.replace("{professor.login}", usuarioProfessor.getLogin());
		texto = texto.replace("{professor.senha}", senha);
		
		enviarEmail(assunto, texto, null, usuarioProfessor.getEmail());
	}

	private String pegarHtmlEmail(String url) {
		InputStream is = getClass().getResourceAsStream(url);
		BufferedInputStream bis = new BufferedInputStream(is);
		ByteArrayOutputStream buf = new ByteArrayOutputStream();
		int result;
		try {
			result = bis.read();
			while (result != -1) {
				byte b = (byte) result;
				buf.write(b);
				result = bis.read();
			}
			return buf.toString("UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

}
