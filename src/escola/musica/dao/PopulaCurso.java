package escola.musica.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;

import escola.musica.modelo.Curso;
import escola.musica.modelo.TipoCurso;

public class PopulaCurso {

	public static void main(String[] args) {
		
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		
		Curso violino = geraCurso("Violino", getDescricao(), "01/01/2014", 4, TipoCurso.CORDAS);
		Curso viola = geraCurso("Viola", getDescricao(), "01/01/2014", 4, TipoCurso.CORDAS);
		Curso violoncello = geraCurso("Violoncello", getDescricao(), "01/01/2014", 4, TipoCurso.CORDAS);
		Curso contrabaixo = geraCurso("Contrabaixo", getDescricao(), "01/01/2014", 4, TipoCurso.CORDAS);
		Curso violao = geraCurso("Violão", getDescricao(), "01/01/2014", 4, TipoCurso.CORDAS);
		Curso guitarra = geraCurso("Guitarra", getDescricao(), "01/01/2014", 4, TipoCurso.CORDAS);
		Curso flauta = geraCurso("Flauta", getDescricao(), "01/02/2014", 4, TipoCurso.MADEIRAS);
		Curso clarinete = geraCurso("Clarinete", getDescricao(), "01/02/2014", 4, TipoCurso.MADEIRAS);
		Curso oboe = geraCurso("Oboé", getDescricao(), "01/02/2014", 5, TipoCurso.MADEIRAS);
		Curso fagote = geraCurso("Fagote", getDescricao(), "01/02/2014", 5, TipoCurso.MADEIRAS);
		Curso saxofone = geraCurso("Saxofone", getDescricao(), "01/02/2014", 5, TipoCurso.MADEIRAS);
		Curso clarone = geraCurso("Clarone", getDescricao(), "01/02/2014", 5, TipoCurso.MADEIRAS);
		Curso trompete = geraCurso("Trompete", getDescricao(), "04/02/2014", 6, TipoCurso.METAIS);
		Curso trompa = geraCurso("Trompa", getDescricao(), "04/01/2014", 6, TipoCurso.METAIS);
		Curso trombone = geraCurso("Trobone", getDescricao(), "04/01/2014", 6, TipoCurso.METAIS);
		Curso tuba = geraCurso("Tuba", getDescricao(), "04/01/2014", 6, TipoCurso.METAIS);
		Curso bateria = geraCurso("Bateria", getDescricao(), "22/01/2014", 3, TipoCurso.PERCUSSAO);
		Curso xilofone = geraCurso("Xilofone", getDescricao(), "22/01/2014", 3, TipoCurso.PERCUSSAO);
		Curso caixa = geraCurso("Caixa", getDescricao(), "22/01/2014", 3, TipoCurso.PERCUSSAO);
		Curso bumbo = geraCurso("Bumbo", getDescricao(), "22/01/2014", 3, TipoCurso.PERCUSSAO);
		
		em.persist(violino);
		em.persist(viola);
		em.persist(violoncello);
		em.persist(contrabaixo);
		em.persist(violao);
		em.persist(guitarra);
		em.persist(flauta);
		em.persist(clarinete);
		em.persist(oboe);
		em.persist(fagote);
		em.persist(clarone);
		em.persist(saxofone);
		em.persist(trompete);
		em.persist(trompa);
		em.persist(trombone);
		em.persist(tuba);
		em.persist(bateria);
		em.persist(xilofone);
		em.persist(caixa);
		em.persist(bumbo);
		
		em.getTransaction().commit();
		em.close();
	}
	
	private static String getDescricao() {
		return "Lorem Ipsum é simplesmente uma simulação " +
				"de texto da indústria tipográfica e de impressos, " +
				"e vem sendo utilizado desde o século XVI, quando " +
				"um impressor desconhecido pegou uma bandeja de " +
				"tipos e os embaralhou para fazer um livro de " +
				"modelos de tipos.";
	}

	public static Curso geraCurso(String nome, String descricao, String data, double duracao, TipoCurso tipo){
		Curso curso = new Curso();
		curso.setNome(nome);
		curso.setDescricao(descricao);
		curso.setDuracao(duracao);
		curso.setDataCriacao(parseData(data));
		curso.setTipo(tipo);
		return curso;
	}
	
	private static Date parseData(String data){
		try{
			Date date = new SimpleDateFormat("dd/MM/yyy").parse(data);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar.getTime();
		}catch(ParseException e){
			throw new IllegalArgumentException(e);
		}
	}
}
