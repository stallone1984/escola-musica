package escola.musica.servico.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import escola.musica.modelo.Aluno;
import escola.musica.servico.AlunoServico;

@Service("alunoServico")
@Transactional
public class AlunoServicoImpl implements AlunoServico{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void salvar(Aluno aluno) {
		entityManager.merge(aluno);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Aluno> listarTodos() {
		return entityManager.createQuery("from Aluno").getResultList();
	}

}
