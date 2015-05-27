package escola.musica.servico;

import java.util.List;

import escola.musica.modelo.Matricula;

public interface MatriculaServico {

	public List<Matricula> listarTodas();
	public void salvar(Matricula matricula);
}
