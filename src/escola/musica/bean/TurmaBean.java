package escola.musica.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import escola.musica.modelo.Curso;
import escola.musica.modelo.Matricula;
import escola.musica.modelo.Semestre;
import escola.musica.modelo.Turma;
import escola.musica.servico.CursoServico;
import escola.musica.servico.MatriculaServico;
import escola.musica.servico.TurmaServico;
import escola.musica.util.Mensagem;

@Controller("turmaBean")
public class TurmaBean implements Serializable {

	private static final long serialVersionUID = 374615860770008608L;

	private Turma turma;
	private List<Turma> turmas;
	private List<Semestre> semestres;
	private List<Curso> cursos;
	private List<Matricula> matriculas;
	
	@Autowired
	private TurmaServico turmaServico;
	@Autowired
	private CursoServico cursoServico;
	@Autowired
	private MatriculaServico matriculaServico;
	
	public void iniciarBean(){
		semestres = Arrays.asList(Semestre.values());
		atualizarTurmas();
		matriculas = matriculaServico.listarTodasAtivas();
		cursos = cursoServico.listarTodos();
	}
	
	public void novaTurma(){
		turma = new Turma();
	}
	
	public void salvarTurma(){
		turmaServico.salvar(turma);
		turma = null;
		atualizarTurmas();
		Mensagem.mensagemInformacao("Turma salva com sucesso!");
	}
	
	public void editarTurma(Turma turma){
		this.turma = turma;
	}
	
	public void cancelarTurma(){
		this.turma = null;
	}
	
	private void atualizarTurmas(){
		turmas = turmaServico.listarTodas();
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public List<Semestre> getSemestres() {
		return semestres;
	}

	public void setSemestres(List<Semestre> semestres) {
		this.semestres = semestres;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

}
