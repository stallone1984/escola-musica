package escola.musica.servico;

import java.util.List;

import escola.musica.modelo.Matricula;
import escola.musica.modelo.MatriculaVO;
import escola.musica.modelo.ParametrosBuscaMatricula;

public interface MatriculaServico {

	public List<MatriculaVO> listarTodas();
	public void salvar(Matricula matricula);
	public List<Matricula> listarTodasAtivas();
	public Matricula obterPorId(Integer id);
	public List<Matricula> listarPorCurso(Integer id);
	public List<MatriculaVO> pesquisar(ParametrosBuscaMatricula parametros);
}
