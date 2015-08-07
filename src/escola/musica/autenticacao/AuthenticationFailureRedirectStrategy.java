package escola.musica.autenticacao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.RedirectStrategy;
import org.springframework.stereotype.Component;

@Component("authenticationFailureRedirectStrategy")
public class AuthenticationFailureRedirectStrategy implements RedirectStrategy {
	
	
	@Override
	public void sendRedirect(HttpServletRequest request,
			HttpServletResponse response, String arg) throws IOException {
		response.sendRedirect(request.getContextPath()+"/pages/login/login.jsf?erro=1");
	}
}