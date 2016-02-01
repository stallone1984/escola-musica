package escola.musica.servico;

import java.util.List;

import escola.musica.modelo.Avaliacao;

public interface AvaliacaoServico {

	public List<Avaliacao> listarTodos();

	public void salvar(Avaliacao avaliacao);

}
