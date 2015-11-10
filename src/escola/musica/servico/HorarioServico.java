package escola.musica.servico;

import java.util.List;

import escola.musica.modelo.Horario;

public interface HorarioServico {

	public Horario salvar(Horario horario);
	public List<Horario> listarPorTurma(Integer idTurma);
	
}
