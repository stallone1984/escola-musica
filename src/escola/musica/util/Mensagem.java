package escola.musica.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Mensagem {

	public static void mensagemInformacao(String mensagem){
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, null));
	}
	
	public static void mensagemAlerta(String mensagem){
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_WARN, mensagem, null));
	}
	
	public static void mensagemErro(String mensagem){
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, null));
	}
}
