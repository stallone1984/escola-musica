package escola.musica.servico.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import escola.musica.modelo.Avaliacao;
import escola.musica.servico.AvaliacaoServico;

@Transactional
@Service("avaliacaoServico")
public class AvaliacaoServicoImpl implements AvaliacaoServico{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Avaliacao> listarTodos() {
		return entityManager.createNamedQuery(Avaliacao.LISTAR_TODOS, 
				Avaliacao.class).getResultList();
	}

	@Override
	public void salvar(Avaliacao avaliacao) {
		entityManager.merge(avaliacao);
		
	}

}
