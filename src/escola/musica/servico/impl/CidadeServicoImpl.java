package escola.musica.servico.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import escola.musica.modelo.Cidade;
import escola.musica.modelo.Estado;
import escola.musica.servico.CidadeServico;

@Service
@Transactional
public class CidadeServicoImpl implements CidadeServico{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void salvar(Cidade cidade) {
		entityManager.merge(cidade);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cidade> listarTodas() {
		return entityManager.createQuery("from Cidade order by nome").getResultList();
	}

	@Override
	public void excluir(Cidade cidade) {
		entityManager.remove(entityManager.merge(cidade));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cidade> obterCidadesDoEstado(Estado estado) {
		return entityManager.createQuery("from Cidade where estado = :uf order by nome")
				.setParameter("uf", estado).getResultList();
	}

}
