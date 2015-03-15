package escola.musica.converter;

import javax.faces.convert.FacesConverter;

import escola.musica.modelo.Cidade;

@FacesConverter("cidadeEntityConverter")
public class CidadeEntityConverter extends EntityConverter<Cidade>{

	public CidadeEntityConverter() {
		super(Cidade.class);
	}

}
