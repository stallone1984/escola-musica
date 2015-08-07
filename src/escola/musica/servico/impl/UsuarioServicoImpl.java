package escola.musica.servico.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import escola.musica.modelo.Usuario;
import escola.musica.servico.UsuarioServico;

@Service("usuarioServico")
@Transactional
public class UsuarioServicoImpl implements UsuarioServico{

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public Usuario obterUsuarioPeloLogin(String login) {
		List<Usuario> usuarios = entityManager.createQuery(
				"from Usuario where login = :login")
				.setParameter("login", login)
				.getResultList();
		
		if(usuarios.isEmpty()){
			return null;
		}
		
		return usuarios.get(0);
	}

}







