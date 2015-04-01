package escola.musica.dao;

import javax.persistence.EntityManager;

import escola.musica.modelo.Cidade;
import escola.musica.modelo.Estado;

public class PopulaCidade {

	public static void main(String[] args) {
		
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		Cidade cidadeSp1 = new Cidade("São José dos Campos", Estado.SAO_PAULO);
		Cidade cidadeSp2 = new Cidade("Caçapava", Estado.SAO_PAULO);
		Cidade cidadeSp3 = new Cidade("Jacareí", Estado.SAO_PAULO);
		Cidade cidadeSp4 = new Cidade("Aparecida", Estado.SAO_PAULO);
		Cidade cidadeSp5 = new Cidade("Taubaté", Estado.SAO_PAULO);
		
		Cidade cidadeRj1 = new Cidade("Resende", Estado.RIO_DE_JANEIRO);
		Cidade cidadeRj2 = new Cidade("Barra Mansa", Estado.RIO_DE_JANEIRO);
		Cidade cidadeRj3 = new Cidade("Macaé", Estado.RIO_DE_JANEIRO);
		Cidade cidadeRj4 = new Cidade("Cabo Frio", Estado.RIO_DE_JANEIRO);
		Cidade cidadeRj5 = new Cidade("Volta Redonda", Estado.RIO_DE_JANEIRO);
		
		Cidade cidadeMg1 = new Cidade("Itajubá", Estado.MINAS_GERAIS);
		Cidade cidadeMg2 = new Cidade("Maria da Fé", Estado.MINAS_GERAIS);
		Cidade cidadeMg3 = new Cidade("Passa Quatro", Estado.MINAS_GERAIS);
		Cidade cidadeMg4 = new Cidade("São Lourenço", Estado.MINAS_GERAIS);
		Cidade cidadeMg5 = new Cidade("Três Corações", Estado.MINAS_GERAIS);
		
		Cidade cidadePr1 = new Cidade("Curitiba", Estado.PARANA);
		Cidade cidadePr2 = new Cidade("São José dos Pinhais", Estado.PARANA);
		Cidade cidadePr3 = new Cidade("Pato Branco", Estado.PARANA);
		Cidade cidadePr4 = new Cidade("Maringá", Estado.PARANA);
		Cidade cidadePr5 = new Cidade("Cascavel", Estado.PARANA);
		
		Cidade cidadeSc1 = new Cidade("Rio do Sul", Estado.SANTA_CATARINA);
		Cidade cidadeSc2 = new Cidade("Blumenau", Estado.SANTA_CATARINA);
		Cidade cidadeSc3 = new Cidade("Chapecó", Estado.SANTA_CATARINA);
		Cidade cidadeSc4 = new Cidade("Joinvile", Estado.SANTA_CATARINA);
		Cidade cidadeSc5 = new Cidade("Petrolândia", Estado.SANTA_CATARINA);
		
		em.persist(cidadeMg1);
		em.persist(cidadeMg2);
		em.persist(cidadeMg3);
		em.persist(cidadeMg4);
		em.persist(cidadeMg5);
		
		em.persist(cidadeSp1);
		em.persist(cidadeSp2);
		em.persist(cidadeSp3);
		em.persist(cidadeSp4);
		em.persist(cidadeSp5);
		
		em.persist(cidadePr1);
		em.persist(cidadePr2);
		em.persist(cidadePr3);
		em.persist(cidadePr4);
		em.persist(cidadePr5);
		
		em.persist(cidadeRj1);
		em.persist(cidadeRj2);
		em.persist(cidadeRj3);
		em.persist(cidadeRj4);
		em.persist(cidadeRj5);
		
		em.persist(cidadeSc1);
		em.persist(cidadeSc2);
		em.persist(cidadeSc3);
		em.persist(cidadeSc4);
		em.persist(cidadeSc5);
		
		em.getTransaction().commit();
		em.close();
	}
}
