package escola.musica.modelo;

public enum Semestre {

	PRIMEIRO("Primeiro Semestre"),
	SEGUNDO("Segundo Semestre"),
	TERCEIRO("Terceiro Semestre"),
	QUARTO("Quarto Semestre");
	
	private String label;

	private Semestre(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	
}
