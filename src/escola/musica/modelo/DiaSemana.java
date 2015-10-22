package escola.musica.modelo;

public enum DiaSemana {

	SEGUNDA("Segunda-Feira"),
	QUARTA("Quarta-Feira"),
	SEXTA("Quinta-Feira");
	
	private String label;

	private DiaSemana(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
}
