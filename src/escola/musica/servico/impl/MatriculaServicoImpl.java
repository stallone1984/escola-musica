package escola.musica.servico.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import escola.musica.modelo.Matricula;
import escola.musica.servico.MatriculaServico;

@Service("matriculaServico")
@Transactional
public class MatriculaServicoImpl implements MatriculaServico{

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Matricula> listarTodas() {
		return entityManager.createQuery("from Matricula").getResultList();
	}

	@Override
	public void salvar(Matricula matricula) {
		entityManager.merge(matricula);
	}

}
