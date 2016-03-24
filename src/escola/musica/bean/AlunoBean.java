package escola.musica.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import escola.musica.dao.GenericDAO;
import escola.musica.modelo.Aluno;
import escola.musica.modelo.Cidade;
import escola.musica.modelo.Estado;
import escola.musica.servico.AlunoServico;
import escola.musica.servico.CidadeServico;
import escola.musica.util.Mensagem;

@Controller("alunoBean")
@Scope("session")
public class AlunoBean implements Serializable {

	private static final long serialVersionUID = -1025252140353914359L;

	private Aluno aluno;
	private List<Aluno> alunos;
	private List<Estado> estados;
	
	@Autowired
	private AlunoServico alunoServico;
	
	@Autowired
	private CidadeServico cidadeServico;

	public void iniciarBean() {
		alunos = alunoServico.listarTodos();
		estados = Arrays.asList(Estado.values());
	}

	public void novoAluno() {
		aluno = new Aluno();
	}

	public void salvar() {
		Aluno alunoExistente = alunoServico.obterPorEmail(aluno.getEmail());
		if(alunoExistente != null && aluno.getId() != alunoExistente.getId()){
			Mensagem.mensagemErro("Já existe um aluno cadastrado com este email");
			return;
		}
		alunoServico.salvar(aluno);
		Mensagem.mensagemInformacao("Aluno cadastrado com sucesso");
		alunos = alunoServico.listarTodos();
		aluno = null;
	}

	public void editar(Aluno aluno) {
		this.aluno = aluno;
	}

	public void voltar() {
		this.aluno = null;
	}

	public String getDataAtual() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -6);
		return new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime());
	}

	public List<Cidade> getCidadesDoEstado() {
		return cidadeServico.obterCidadesDoEstado(aluno.getEndereco().getCidade()
				.getEstado());
	}
	
	public void enviarFoto(FileUploadEvent event){
		try {
			byte[] foto = IOUtils.toByteArray(
					event.getFile().getInputstream());
			aluno.setFoto(foto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public StreamedContent getImagemAluno(){
		Map<String, String> mapaParametros = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap();
		String idAluno = mapaParametros.get("id_aluno");
		if(idAluno != null){
			Aluno alunoBanco = new GenericDAO<Aluno>(Aluno.class)
					.obterPorId(new Integer(idAluno));
			return alunoBanco.getImagem();
		}
		
		return new DefaultStreamedContent();
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

}
