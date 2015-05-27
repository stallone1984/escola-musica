package escola.musica.converter;

import javax.faces.convert.FacesConverter;

import escola.musica.modelo.Aluno;

@FacesConverter("alunoConverter")
public class AlunoConverter extends EntityConverter<Aluno>{

	public AlunoConverter() {
		super(Aluno.class);
	}

}
