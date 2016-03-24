package escola.musica.servico.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import escola.musica.modelo.Matricula;
import escola.musica.modelo.MatriculaVO;
import escola.musica.modelo.ParametrosBuscaMatricula;
import escola.musica.servico.MatriculaServico;
import escola.musica.util.DataUtils;

@Service("matriculaServico")
@Transactional
public class MatriculaServicoImpl implements MatriculaServico{
	
	private static final String FORMATO_BANCO_MYSQL = "yyyy-MM-dd";

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MatriculaVO> listarTodas() {
		return entityManager.createNamedQuery(Matricula.LISTAR_TODAS).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Matricula> listarTodasAtivas() {
		return entityManager.createNamedQuery("Matricula.ListarTodasAtivas").getResultList();
	}

	@Override
	public void salvar(Matricula matricula) {
		entityManager.merge(matricula);
	}

	@Override
	public Matricula obterPorId(Integer id) {
		return entityManager.find(Matricula.class, id);
	}

	@Override
	public List<Matricula> listarPorCurso(Integer id) {
		return entityManager.createNamedQuery(Matricula.LISTAR_POR_CURSO, Matricula.class)
				.setParameter("idCurso", id).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MatriculaVO> pesquisar(ParametrosBuscaMatricula parametros) {
		StringBuilder builder = new StringBuilder("select new escola.musica.modelo.MatriculaVO(" +
			"m.id, m.numero, m.dataMatricula, m.aluno.nome, m.curso.nome) from Matricula m where m.id is not null ");
		
		if(parametros.getAluno() != null){
			builder.append(" and m.aluno = :aluno");
		}
		
		if(parametros.getCursos() != null && !parametros.getCursos().isEmpty()){
			builder.append(" and m.curso in (:cursos)");
		}
		
		if(parametros.getDataInicial() != null){
			builder.append(" and date(m.dataMatricula) >= '" + DataUtils
					.obterDataFormatoBanco(parametros.getDataInicial(), FORMATO_BANCO_MYSQL) + "'");
		}
		
		if(parametros.getDataFinal() != null){
			builder.append(" and date(m.dataMatricula) <= '" + DataUtils
					.obterDataFormatoBanco(parametros.getDataFinal(), FORMATO_BANCO_MYSQL) + "'");
		}
		
		Query query = entityManager.createQuery(builder.toString());
		
		if(parametros.getAluno() == null){
			query.setParameter("aluno", parametros.getAluno());
		}
		
		if(parametros.getCursos() != null && !parametros.getCursos().isEmpty()){
			query.setParameter("cursos", parametros.getCursos());
		}
		
		return query.getResultList();
	}

	@Override
	public Long obterNumeroUltimaMatricula() {
		return (Long) entityManager.createNamedQuery(
				Matricula.OBTER_NUMERO_ULTIMA_MATRICULA).getSingleResult();
	}

}
