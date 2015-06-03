package escola.musica.modelo;

import java.util.Date;

public class MatriculaVO {

	private Integer id;
	private String numero;
	private Date data;
	private String nomeAluno;
	private String nomeCurso;

	public MatriculaVO(Integer id, String numero, Date data, String nomeAluno,
			String nomeCurso) {
		super();
		this.id = id;
		this.numero = numero;
		this.data = data;
		this.nomeAluno = nomeAluno;
		this.nomeCurso = nomeCurso;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

}
