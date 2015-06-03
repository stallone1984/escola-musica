package escola.musica.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import escola.musica.dao.CursoDAO;
import escola.musica.modelo.Curso;
import escola.musica.modelo.TipoCurso;
import escola.musica.servico.CursoServico;
import escola.musica.util.Mensagem;

@Controller("cursoBean")
@Scope("session")
public class CursoBean implements Serializable{

	private static final long serialVersionUID = -862660658464075437L;

	private Curso curso;
	private List<TipoCurso> tipos;
	private List<Curso> cursos = new ArrayList<Curso>();
	private List<Curso> cursosAccordion = new ArrayList<Curso>();
	private Curso cursoExclusao;
	private List<Curso> cursosFiltrados;
	
	@Autowired
	private CursoServico cursoServico;
	
	public void iniciarBean(){
		cursos = cursoServico.listarTodos();
		cursosAccordion = cursoServico.listarCursosAccordion();
		tipos = Arrays.asList(TipoCurso.values());
	}
	
	public void novoCurso(){
		curso = new Curso();
	}

	public void salvar() throws InterruptedException{
		Thread.sleep(2000);
		cursoServico.salvar(curso);
		//new CursoDAO().salvar(curso);
		cursos = cursoServico.listarTodos();
		//cursos = new CursoDAO().listarTodos();
		curso = null;
		Mensagem.mensagemInformacao("Curso salvo com sucesso");
		
	}
	
	public void editar(Curso curso){
		this.curso = curso;
	}
	
	public void prepararExclusao(Curso curso){
		this.cursoExclusao = curso;
	}
	
	public void excluir(){
		cursoServico.excluir(cursoExclusao);
		Mensagem.mensagemInformacao("Curso excluído com sucesso!");
		cursos = new CursoDAO().listarTodos();
		cursosFiltrados = null;
	}
	
	public void voltar(){
		curso = null;
	}
	
	public String getDataAtual(){
		return new SimpleDateFormat("dd/MM/yyyy")
			.format(new Date());
	}
	
	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<TipoCurso> getTipos() {
		return tipos;
	}

	public void setTipos(List<TipoCurso> tipos) {
		this.tipos = tipos;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public List<Curso> getCursosAccordion() {
		return cursosAccordion;
	}

	public void setCursosAccordion(List<Curso> cursosAccordion) {
		this.cursosAccordion = cursosAccordion;
	}

	public Curso getCursoExclusao() {
		return cursoExclusao;
	}

	public void setCursoExclusao(Curso cursoExclusao) {
		this.cursoExclusao = cursoExclusao;
	}

	public List<Curso> getCursosFiltrados() {
		return cursosFiltrados;
	}

	public void setCursosFiltrados(List<Curso> cursosFiltrados) {
		this.cursosFiltrados = cursosFiltrados;
	}
	
}
