package escola.musica.servico.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import escola.musica.modelo.Horario;
import escola.musica.servico.HorarioServico;

@Service("horarioServico")
@Transactional
public class HorarioServicoImpl implements HorarioServico{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void salvar(Horario horario) {
		entityManager.merge(horario);
	}

	@Override
	public List<Horario> listarPorTurma(Integer idTurma) {
		return entityManager.createNamedQuery(Horario.LISTAR_POR_TURMA)
				.setParameter("idTurma", idTurma).getResultList();
	}

}
