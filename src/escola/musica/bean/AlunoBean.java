package escola.musica.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import escola.musica.dao.GenericDAO;
import escola.musica.modelo.Aluno;

@ManagedBean
@ViewScoped
public class AlunoBean implements Serializable {

	private static final long serialVersionUID = -1025252140353914359L;

	private Aluno aluno;
	private List<Aluno> alunos;
	
	public void iniciarBean(){
		alunos = new GenericDAO<Aluno>(Aluno.class).listarTodos();
	}
	
	public void novoAluno(){
		aluno = new Aluno();
	}
	
	public void salvar(){
		new GenericDAO<Aluno>(Aluno.class).salvar(aluno);
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("Aluno cadastrado com sucesso"));
		alunos = new GenericDAO<Aluno>(Aluno.class).listarTodos();
		aluno = null;
	}
	
	public void editar(Aluno aluno){
		this.aluno = aluno;
	}
	
	public void voltar(){
		this.aluno = null;
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

}
