package escola.musica.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@NamedQueries({
	@NamedQuery(name = Avaliacao.LISTAR_TODOS, query = Avaliacao.LISTAR_TODOS)
})
public class Avaliacao implements Serializable {

	private static final long serialVersionUID = 8474601867304012957L;

	public static final String LISTAR_TODOS = "from Avaliacao";

	private Integer id;
	private Matricula matricula;
	private Bimestre bimestre;
	private Integer ano;
	private Double nota;
	private Date data;
	private Arquivo arquivo;

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "id_matricula")
	@NotNull(message = "Selecione a matrícula!")
	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	@Enumerated(EnumType.STRING)
	@NotNull(message = "Selecione o bimestre!")
	public Bimestre getBimestre() {
		return bimestre;
	}

	public void setBimestre(Bimestre bimestre) {
		this.bimestre = bimestre;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	@Temporal(TemporalType.DATE)
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@OneToOne
	@JoinColumn(name = "id_arquivo")
	public Arquivo getArquivo() {
		return arquivo;
	}

	public void setArquivo(Arquivo arquivo) {
		this.arquivo = arquivo;
	}

}
