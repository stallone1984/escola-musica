package escola.musica.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import escola.musica.dao.CidadeDAO;
import escola.musica.dao.GenericDAO;
import escola.musica.modelo.Aluno;
import escola.musica.modelo.Cidade;
import escola.musica.modelo.Estado;

@ManagedBean
@SessionScoped
public class AlunoBean implements Serializable {

	private static final long serialVersionUID = -1025252140353914359L;

	private Aluno aluno;
	private List<Aluno> alunos;
	private List<Estado> estados;

	public void iniciarBean() {
		alunos = new GenericDAO<Aluno>(Aluno.class).listarTodos();
		estados = Arrays.asList(Estado.values());
	}

	public void novoAluno() {
		aluno = new Aluno();
	}

	public void salvar() {
		new GenericDAO<Aluno>(Aluno.class).salvar(aluno);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Aluno cadastrado com sucesso"));
		alunos = new GenericDAO<Aluno>(Aluno.class).listarTodos();
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
		return CidadeDAO.obterCidadesDoEstado(aluno.getEndereco().getCidade()
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
