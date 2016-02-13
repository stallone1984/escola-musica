package escola.musica.servico.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import escola.musica.modelo.Arquivo;
import escola.musica.servico.ArquivoServico;

@Service(value = "arquivoServico")
@Transactional
public class ArquivoServicoImpl implements ArquivoServico{
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	@Qualifier("filesDir")
	private String folderPath;
	
	@Override
	public Arquivo inserirArquivoNoSistema(Arquivo arquivo, String diretorio) {
		if (arquivo == null) {
			return null;
		}
		
		if (arquivo.getStream() == null && arquivo.getFile() != null) {
			try {
				arquivo.setStream(new FileInputStream(arquivo.getFile()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			if (arquivo.getStream() != null
					&& arquivo.getStream().available() > 0) {
				montarArquivo(arquivo, diretorio);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		arquivo.setCaminho(diretorio);
		Arquivo arquivoSalvo = entityManager.merge(arquivo);
		arquivoSalvo.setFile(arquivo.getFile());
		return arquivoSalvo;
	}
	
	private void montarArquivo(Arquivo arquivo, String diretorio) throws IOException {
		File file = obterArquivo(arquivo.getNome(), diretorio);
		salvarStreamNoArquivo(arquivo.getStream(), file);
		arquivo.setFile(file);
	}
	
	@Override
	public File obterArquivo(String nomeArquivo, String nomeDiretorio) {
		//folderPath = System.getProperty("user.home");
		//File diretorioRaiz = new File(folderPath + "/" + "escola_musica");
		File diretorioRaiz = new File(folderPath);
		File diretorio = new File(diretorioRaiz, nomeDiretorio);
		if (!diretorio.exists()) {
			diretorio.mkdirs();
		}
		File file = new File(diretorio, nomeArquivo);
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return file;
	}
	
	private void salvarStreamNoArquivo(InputStream stream, File file) throws IOException {
		if (stream.available() <= 0) {
			return;
		}
		OutputStream out = new FileOutputStream(file);
		byte buf[] = new byte[1024];
		int len;
		while ((len = stream.read(buf)) > 0) {
			out.write(buf, 0, len);
		}
		out.close();
		stream.close();
	}
}
