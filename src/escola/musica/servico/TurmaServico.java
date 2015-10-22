package escola.musica.servico;

import java.util.List;

import escola.musica.modelo.Turma;

public interface TurmaServico {

	public void salvar(Turma turma);
	public List<Turma> listarTodas();
}
