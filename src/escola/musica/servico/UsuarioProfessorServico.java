package escola.musica.servico;

import java.util.List;

import escola.musica.modelo.UsuarioProfessor;

public interface UsuarioProfessorServico {

	public void salvar(UsuarioProfessor usuarioProfessor);
	public List<UsuarioProfessor> listarTodos();
}
