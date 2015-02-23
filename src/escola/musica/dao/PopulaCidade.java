package escola.musica.dao;

import javax.persistence.EntityManager;

import escola.musica.modelo.Cidade;
import escola.musica.modelo.Estado;

public class PopulaCidade {

	public static void main(String[] args) {
		
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		Cidade cidadeSp1 = new Cidade("São José dos Campos", Estado.SP);
		Cidade cidadeSp2 = new Cidade("Caçapava", Estado.SP);
		Cidade cidadeSp3 = new Cidade("Jacareí", Estado.SP);
		Cidade cidadeSp4 = new Cidade("Aparecida", Estado.SP);
		Cidade cidadeSp5 = new Cidade("Taubaté", Estado.SP);
		
		Cidade cidadeRj1 = new Cidade("Resende", Estado.RJ);
		Cidade cidadeRj2 = new Cidade("Barra Mansa", Estado.RJ);
		Cidade cidadeRj3 = new Cidade("Macaé", Estado.RJ);
		Cidade cidadeRj4 = new Cidade("Cabo Frio", Estado.RJ);
		Cidade cidadeRj5 = new Cidade("Volta Redonda", Estado.RJ);
		
		Cidade cidadeMg1 = new Cidade("Itajubá", Estado.MG);
		Cidade cidadeMg2 = new Cidade("Maria da Fé", Estado.MG);
		Cidade cidadeMg3 = new Cidade("Passa Quatro", Estado.MG);
		Cidade cidadeMg4 = new Cidade("São Lourenço", Estado.MG);
		Cidade cidadeMg5 = new Cidade("Três Corações", Estado.MG);
		
		Cidade cidadePr1 = new Cidade("Curitiba", Estado.PR);
		Cidade cidadePr2 = new Cidade("São José dos Pinhais", Estado.PR);
		Cidade cidadePr3 = new Cidade("Pato Branco", Estado.PR);
		Cidade cidadePr4 = new Cidade("Maringá", Estado.PR);
		Cidade cidadePr5 = new Cidade("Cascavel", Estado.PR);
		
		Cidade cidadeSc1 = new Cidade("Rio do Sul", Estado.SC);
		Cidade cidadeSc2 = new Cidade("Blumenau", Estado.SC);
		Cidade cidadeSc3 = new Cidade("Chapecó", Estado.SC);
		Cidade cidadeSc4 = new Cidade("Joinvile", Estado.SC);
		Cidade cidadeSc5 = new Cidade("Petrolândia", Estado.SC);
		
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
