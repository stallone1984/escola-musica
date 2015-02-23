package escola.musica.modelo;

public enum Estado {

	SP("São Paulo"),
	RJ("Rio de Janeiro"),
	PR("Paraná"),
	SC("Santa Catarina"),
	MG("Minas Gerais");
	
	private String label;

	private Estado(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
}
