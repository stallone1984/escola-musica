package escola.musica.autenticacao;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

@Component("authorizationFilter")
public class AuthorizationFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		String path = ((HttpServletRequest) req).getServletPath();

		if (((HttpServletRequest) req).getQueryString() != null) {
			path = path + "?" + ((HttpServletRequest) req).getQueryString();
		}
		path = URLDecoder.decode(path, "UTF-8");
		
		if(path.contains("/pages/login/login.jsf")){
			chain.doFilter(req, resp);
			return;
		}
		
		if(path.contains("/pages/template/main.jsf")){
			chain.doFilter(req, resp);
			return;
		}
		
		/*if(path.contains("/manutencao/")){
			chain.doFilter(req, resp);
			return;
		}*/
		
		if (path.contains("css") || path.endsWith("js") || path.contains("fonts") || path.contains("images") 
				|| path.contains("javax.faces.resource")) {
			chain.doFilter(req, resp);
			return;
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
