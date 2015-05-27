package escola.musica.servico.impl;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import escola.musica.servico.EnvioEmailServico;

@Service
public class EnvioEmailServicoImpl implements EnvioEmailServico{

	@Override
	//@Scheduled(fixedDelay = 5000)
	//@Scheduled(cron = "30 42 1 * * *")
	public void enviarEmail() {
		System.out.println("Enviando email...");
	}

}
