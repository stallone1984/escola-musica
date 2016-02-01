package escola.musica.servico.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import escola.musica.modelo.Avaliacao;
import escola.musica.modelo.Bimestre;
import escola.musica.modelo.Matricula;
import escola.musica.servico.AvaliacaoServico;
import escola.musica.servico.MatriculaServico;
import escola.musica.util.Mensagem;

@Controller("avaliacaoBean")
@Scope("view")
public class AvaliacaoBean implements Serializable{

	private static final long serialVersionUID = -8252061108575877564L;

	private Avaliacao avaliacao;
	private List<Avaliacao> avaliacoes;
	private List<Matricula> matriculas;
	
	@Autowired
	private AvaliacaoServico avaliacaoServico;
	@Autowired
	private MatriculaServico matriculaServico;
	
	public void iniciarBean(){
		listarAvaliacoes();
		matriculas = matriculaServico.listarTodasAtivas();
	}
	
	public void salvar(){
		avaliacaoServico.salvar(avaliacao);
		Mensagem.mensagemInformacao("Avaliação cadastrada com sucesso");
		listarAvaliacoes();
		avaliacao = null;
	}
	
	public void cancelar(){
		avaliacao = null;
	}

	private void listarAvaliacoes() {
		avaliacoes = avaliacaoServico.listarTodos();
	}
	
	public void novaAvaliacao(){
		avaliacao = new Avaliacao();
	}
	
	public List<Bimestre> getBimestres(){
		return Arrays.asList(Bimestre.values());
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}
	
}
