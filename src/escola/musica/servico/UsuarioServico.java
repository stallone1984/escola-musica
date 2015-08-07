package escola.musica.servico;

import escola.musica.modelo.Usuario;

public interface UsuarioServico {

	public Usuario obterUsuarioPeloLogin(String login);
}
