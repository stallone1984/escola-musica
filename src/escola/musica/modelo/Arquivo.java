package escola.musica.modelo;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Arquivo implements Serializable {

	private static final long serialVersionUID = -1309391811330747193L;
	private Integer id;
	private String nome;
	private String caminho;
	private InputStream stream;
	private File file;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	@Transient
	public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}

	@Transient
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

}
