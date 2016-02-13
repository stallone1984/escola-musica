package escola.musica.servico;

import java.io.File;
import java.util.List;

import escola.musica.modelo.Avaliacao;

public interface AvaliacaoServico {

	public List<Avaliacao> listarTodos();

	public void salvar(Avaliacao avaliacao);

	public File obterArquivoAvaliacao(Avaliacao avaliacao);

}
