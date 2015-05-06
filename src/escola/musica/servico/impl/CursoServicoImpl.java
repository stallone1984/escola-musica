package escola.musica.servico.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import escola.musica.modelo.Curso;
import escola.musica.servico.CursoServico;

@Service(value = "cursoServico")
@Transactional
public class CursoServicoImpl implements CursoServico{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void salvar(Curso curso) {
		entityManager.merge(curso);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Curso> listarTodos() {
		return entityManager.createQuery("from Curso").getResultList();
	}

	@Override
	public void excluir(Curso curso) {
		curso = entityManager.merge(curso);
		entityManager.remove(curso);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Curso> listarCursosAccordion() {
		return entityManager.createQuery("from Curso where nome in ('Violino', " +
				"'Bateria', 'Clarinete', 'Flauta', 'Guitarra', 'Violão', 'Oboé') order by nome").getResultList();
	}

}
