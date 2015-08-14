package escola.musica.modelo;

import javax.persistence.Entity;

@Entity
public class UsuarioAluno extends Usuario{

	private static final long serialVersionUID = 7805769236030857016L;
	
	private String cpf;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	

}
