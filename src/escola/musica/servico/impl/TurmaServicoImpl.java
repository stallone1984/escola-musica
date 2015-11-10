package escola.musica.servico.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import escola.musica.modelo.Turma;
import escola.musica.servico.TurmaServico;

@Service("turmaServico")
@Transactional
public class TurmaServicoImpl implements TurmaServico{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void salvar(Turma turma) {
		entityManager.merge(turma);
	}

	@Override
	public List<Turma> listarTodas() {
		// TODO - Mostrar Hibernate.initialize()
		return entityManager.createQuery("select t from Turma t").getResultList();
	}

}
