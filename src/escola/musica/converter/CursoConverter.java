package escola.musica.converter;

import javax.faces.convert.FacesConverter;

import escola.musica.modelo.Curso;

@FacesConverter("cursoConverter")
public class CursoConverter extends EntityConverter<Curso>{

	public CursoConverter() {
		super(Curso.class);
	}

}
