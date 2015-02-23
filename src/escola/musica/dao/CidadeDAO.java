package escola.musica.dao;

import java.util.List;

import javax.persistence.EntityManager;

import escola.musica.modelo.Cidade;
import escola.musica.modelo.Estado;

public class CidadeDAO {

	@SuppressWarnings("unchecked")
	public static List<Cidade> obterCidadesDoEstado(Estado estado){
		EntityManager em = JPAUtil.getEntityManager();
		
		List<Cidade> cidades = em.createQuery("from Cidade where estado = :uf")
				.setParameter("uf", estado).getResultList();
		
		em.close();
		
		return cidades;
	}
}
