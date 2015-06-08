package escola.musica.dao;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import escola.musica.modelo.Aluno;
import escola.musica.modelo.Cidade;
import escola.musica.modelo.Endereco;

public class PopulaAluno {

	public static void main(String[] args) {
		
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		
		Aluno aluno1 = geraAluno("João Pedro", (new GregorianCalendar(2000, 11, 20).getTime()), "472.286.741-03", "aluno1@email.test", true, "(12)323454567", 
				geraEndereco("Rua Da Alegria", 79, "12235-000", obterCidadePorId(6)));
		Aluno aluno2 = geraAluno("Guilherme Silva", (new GregorianCalendar(1990, 11, 20).getTime()), "860.461.629-20", "aluno2@email.test", true, "(12)323454567", 
				geraEndereco("Rua Da Alegria", 79, "12235-000", obterCidadePorId(6)));
		Aluno aluno3 = geraAluno("Maria Lúcia", (new GregorianCalendar(2001, 10, 20).getTime()), "471.553.811-36", "aluno3@email.test", true, "(12)323454567", 
				geraEndereco("Rua Da Alegria", 79, "12235-000", obterCidadePorId(6)));
		Aluno aluno4 = geraAluno("Leticia Helena", (new GregorianCalendar(1998, 11, 24).getTime()), "337.746.138-85", "aluno4@email.test", true, "(12)323454567", 
				geraEndereco("Rua Da Alegria", 79, "12235-000", obterCidadePorId(6)));
		Aluno aluno5 = geraAluno("Ana carolina", (new GregorianCalendar(2002, 7, 20).getTime()), "950.716.546-01", "aluno5@email.test", true, "(12)323454567", 
				geraEndereco("Rua Da Alegria", 79, "12235-000", obterCidadePorId(6)));
		Aluno aluno6 = geraAluno("Amanda Caroline", (new GregorianCalendar(2006, 4, 20).getTime()), "848.105.334-17", "aluno6@email.test", true, "(12)323454567", 
				geraEndereco("Rua Da Alegria", 79, "12235-000", obterCidadePorId(6)));
		Aluno aluno7 = geraAluno("Matheus Sávio", (new GregorianCalendar(2003, 10, 20).getTime()), "563.352.972-30", "aluno7@email.test", true, "(12)323454567", 
				geraEndereco("Rua Da Alegria", 79, "12235-000", obterCidadePorId(6)));
		Aluno aluno8 = geraAluno("Gustavo Lima", (new GregorianCalendar(2005, 1, 20).getTime()), "507.806.248-31", "aluno8@email.test", true, "(12)323454567", 
				geraEndereco("Rua Da Alegria", 79, "12235-000", obterCidadePorId(6)));
		Aluno aluno9 = geraAluno("Julia Gabriela", (new GregorianCalendar(2002, 5, 20).getTime()), "593.542.608-02", "aluno9@email.test", true, "(12)323454567", 
				geraEndereco("Rua Da Alegria", 79, "12235-000", obterCidadePorId(6)));
		Aluno aluno10 = geraAluno("Helio Nascimento", (new GregorianCalendar(1984, 11, 20).getTime()), "132.618.032-07", "aluno10@email.test", true, "(12)323454567", 
				geraEndereco("Rua Da Alegria", 79, "12235-000", obterCidadePorId(6)));
		Aluno aluno11 = geraAluno("Felipe Jacó", (new GregorianCalendar(1989, 11, 20).getTime()), "783.729.142-57", "aluno11@email.test", true, "(12)323454567", 
				geraEndereco("Rua Da Alegria", 79, "12235-000", obterCidadePorId(6)));
		Aluno aluno12 = geraAluno("Rafael Pezenti", (new GregorianCalendar(2003, 9, 23).getTime()), "752.147.505-44", "aluno12@email.test", true, "(12)323454567", 
				geraEndereco("Rua Da Alegria", 79, "12235-000", obterCidadePorId(6)));
		Aluno aluno13 = geraAluno("Ana Lúcia", (new GregorianCalendar(2002, 1, 20).getTime()), "746.527.457-53", "aluno13@email.test", true, "(12)323454567", 
				geraEndereco("Rua Da Alegria", 79, "12235-000", obterCidadePorId(6)));
		Aluno aluno14 = geraAluno("Daniel Alves", (new GregorianCalendar(2009, 11, 20).getTime()), "103.315.237-44", "aluno14@email.test", true, "(12)323454567", 
				geraEndereco("Rua Da Alegria", 79, "12235-000", obterCidadePorId(6)));
		Aluno aluno15 = geraAluno("Neymar Júnior", (new GregorianCalendar(2005, 11, 29).getTime()), "861.879.748-08", "aluno15@email.test", true, "(12)323454567", 
				geraEndereco("Rua Da Alegria", 79, "12235-000", obterCidadePorId(6)));
		
			
		em.persist(aluno1);
		em.persist(aluno2);
		em.persist(aluno3);
		em.persist(aluno4);
		em.persist(aluno5);
		em.persist(aluno6);
		em.persist(aluno7);
		em.persist(aluno8);
		em.persist(aluno9);
		em.persist(aluno10);
		em.persist(aluno11);
		em.persist(aluno12);
		em.persist(aluno13);
		em.persist(aluno14);
		em.persist(aluno15);
		
		em.getTransaction().commit();
		em.close();
	}
	
	public static Aluno geraAluno(String nome, Date dataNascimento, String cpf, String email, boolean ativo, 
			String telefone, Endereco endereco){
		Aluno aluno = new Aluno();
		aluno.setNome(nome);
		aluno.setDataNascimento(dataNascimento);
		aluno.setCpf(cpf);
		aluno.setEmail(email);
		aluno.setAtivo(ativo);
		aluno.setTelefone(telefone);
		aluno.setEndereco(endereco);
		
		return aluno;
	}
	
	public static Endereco geraEndereco(String logradouro, Integer numero, String cep, Cidade cidade){
		Endereco endereco = new Endereco();
		endereco.setLogradouro(logradouro);
		endereco.setNumero(numero);
		endereco.setCep(cep);
		endereco.setCidade(cidade);
		
		return endereco;
	}
	
	public static Cidade obterCidadePorId(Integer id){
		return new GenericDAO<Cidade>(Cidade.class).obterPorId(id);
	}
}
