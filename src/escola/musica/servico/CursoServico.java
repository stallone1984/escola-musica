package escola.musica.servico;

import java.util.List;

import escola.musica.modelo.Curso;

public interface CursoServico {

	public void salvar(Curso curso);
	public List<Curso> listarTodos();
	public void excluir(Curso curso);
	public List<Curso> listarCursosAccordion();
}
