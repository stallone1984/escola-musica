package escola.musica.servico;

import java.io.File;
import java.util.List;

import escola.musica.modelo.Avaliacao;
import escola.musica.modelo.UsuarioProfessor;

public interface EnvioEmailServico {

	public void enviarEmail(String assunto, String texto, 
			List<File> anexos, String... destinatarios);
	public void enviarEmailCadastroUsuarioProfessor(
			UsuarioProfessor usuarioProfessor, String senha);
	public void enviarEmailCorrecaoAvaliacao(Avaliacao avaliacao);
}
