package escola.musica.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import escola.musica.modelo.Aluno;
import escola.musica.modelo.Curso;
import escola.musica.modelo.Matricula;
import escola.musica.modelo.MatriculaVO;
import escola.musica.servico.AlunoServico;
import escola.musica.servico.CursoServico;
import escola.musica.servico.MatriculaServico;
import escola.musica.util.Mensagem;

@Controller("matriculaBean")
@Scope("session")
@ManagedBean
public class MatriculaBean implements Serializable {

	private static final long serialVersionUID = -6018503417460500546L;

	private Matricula matricula;
	private List<Matricula> matriculas;
	private List<MatriculaVO> matriculaVos;
	private List<Aluno> alunos;
	private List<Curso> cursos;

	@Autowired
	private MatriculaServico matriculaServico;
	@Autowired
	private AlunoServico alunoServico;
	@Autowired
	private CursoServico cursoServico;

	public void iniciarBean() {
		atualizarMatriculas();
		alunos = alunoServico.listarTodos();
		cursos = cursoServico.listarTodos();
	}
	
	public void salvar(){
		if(matricula.getNumero().length() < 3){
			Mensagem.mensagemErro("O campo matrícula deve ter no mínimo 3 caracteres");
			return;
		}
		matriculaServico.salvar(matricula);
		atualizarMatriculas();
		matricula = null;
		Mensagem.mensagemInformacao("Matrícula cadastrada com sucesso!");
	}
	
	public void novaMatricula(){
		matricula = new Matricula();
	}
	
	public void editar(Integer id){
		this.matricula = matriculaServico.obterPorId(id);
	}
	
	public void cancelar(){
		matricula = null;
	}

	private void atualizarMatriculas() {
		//matriculas = matriculaServico.listarTodas();
		matriculaVos = matriculaServico.listarTodas();
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public List<MatriculaVO> getMatriculaVos() {
		return matriculaVos;
	}

	public void setMatriculaVos(List<MatriculaVO> matriculaVos) {
		this.matriculaVos = matriculaVos;
	}

	
}
