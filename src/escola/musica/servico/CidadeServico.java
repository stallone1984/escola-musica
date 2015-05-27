package escola.musica.servico;

import java.util.List;

import escola.musica.modelo.Cidade;
import escola.musica.modelo.Estado;

public interface CidadeServico {

	public void salvar(Cidade cidade);
	public List<Cidade> listarTodas();
	public void excluir(Cidade cidade);
	public List<Cidade> obterCidadesDoEstado(Estado estado);
}
