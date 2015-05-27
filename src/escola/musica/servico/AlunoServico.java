package escola.musica.servico;

import java.util.List;

import escola.musica.modelo.Aluno;

public interface AlunoServico {

	public void salvar(Aluno aluno);
	public List<Aluno> listarTodos();
}
