package escola.musica.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.primefaces.event.DragDropEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import escola.musica.dao.GenericDAO;
import escola.musica.modelo.Aluno;
import escola.musica.modelo.Matricula;
import escola.musica.servico.MatriculaServico;

@Controller("turmaBean")
@Scope("session")
public class TurmaBean implements Serializable {

	private static final long serialVersionUID = 374615860770008608L;

	private List<Matricula> matriculas;
	private List<Matricula> matriculasInseridas = new ArrayList<Matricula>();

	@Autowired
	private MatriculaServico matriculaServico;

	public void iniciarBean() {
		matriculas = matriculaServico.listarTodasAtivas();
	}
	
	public void onMatriculaDrop(DragDropEvent event){
	  Matricula matricula =	(Matricula) event.getData();
	  matriculas.remove(matricula);
	  matriculasInseridas.add(matricula);
	}

	public StreamedContent getImagemAluno() {
		Map<String, String> mapaParametros = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap();
		String idAluno = mapaParametros.get("id_aluno");
		if (idAluno != null) {
			Aluno alunoBanco = new GenericDAO<Aluno>(Aluno.class)
					.obterPorId(new Integer(idAluno));
			return alunoBanco.getImagem();
		}

		return new DefaultStreamedContent();
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public List<Matricula> getMatriculasInseridas() {
		return matriculasInseridas;
	}

	public void setMatriculasInseridas(List<Matricula> matriculasInseridas) {
		this.matriculasInseridas = matriculasInseridas;
	}

	public MatriculaServico getMatriculaServico() {
		return matriculaServico;
	}

	public void setMatriculaServico(MatriculaServico matriculaServico) {
		this.matriculaServico = matriculaServico;
	}

}
