package escola.musica.modelo;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = UsuarioProfessor.LISTAR_TODOS, query = UsuarioProfessor.LISTAR_TODOS)
})
public class UsuarioProfessor extends Usuario {

	private static final long serialVersionUID = -5479955455017618076L;

	public static final String LISTAR_TODOS = "from UsuarioProfessor";

	private String grauIntrucao;

	public String getGrauIntrucao() {
		return grauIntrucao;
	}

	public void setGrauIntrucao(String grauIntrucao) {
		this.grauIntrucao = grauIntrucao;
	}

}
