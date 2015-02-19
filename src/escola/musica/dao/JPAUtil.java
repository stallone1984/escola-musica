package escola.musica.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	public static EntityManager getEntityManager(){
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("escola_musica");
		
		return factory.createEntityManager();
	}
}
