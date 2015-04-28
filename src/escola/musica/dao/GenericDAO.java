package escola.musica.dao;

import java.util.List;

import javax.persistence.EntityManager;

public class GenericDAO<T> {

	private final Class<T> classe;
	
	public GenericDAO(Class<T> classe){
		this.classe = classe;
	}
	
	public void salvar(T t){
		EntityManager em = JPAUtil.getEntityManager();
		
		em.getTransaction().begin();
		
		em.merge(t);
		
		em.getTransaction().commit();
		
		em.close();
	}
	
	public void excluir(T t){
		EntityManager em = JPAUtil.getEntityManager();
		
		em.getTransaction().begin();
		
		em.remove(em.merge(t));
		
		em.getTransaction().commit();
		
		em.close();
	}
	
	public List<T> listarTodos(){
		EntityManager em = JPAUtil.getEntityManager();
		
		List<T> resultados = em.createQuery(
				"select c from " + classe.getName() + " c", classe).getResultList();
		
		 em.close();
		
		return resultados;
	}
	
	public T obterPorId(Integer id){
		EntityManager em = JPAUtil.getEntityManager();
		
		T t = em.createQuery("from " + classe.getName() + " where id = :cod", classe)
				.setParameter("cod", id).getSingleResult();
		
		em.close();
		
		return t;
	}
	
}
