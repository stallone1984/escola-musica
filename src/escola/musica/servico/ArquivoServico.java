package escola.musica.servico;

import java.io.File;

import escola.musica.modelo.Arquivo;

public interface ArquivoServico {
	public Arquivo inserirArquivoNoSistema(Arquivo arquivo, String diretorio);
	public File obterArquivo(String nomeArquivo, String diretorio);
}
