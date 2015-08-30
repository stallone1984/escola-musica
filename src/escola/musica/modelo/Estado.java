package escola.musica.modelo;

public enum Estado {

	ACRE("Acre","AC"),
	ALAGOAS("Alagoas","AL"),
	AMAPA("Amapá","AP"),
	AMAZONAS("Amazonas", "AM"),
	BAHIA("Bahia","BA"),
	CEARA("Ceará","CE"),
	DISTRITO_FEDERAL("Distrito Federal","DF"),
	ESPIRITO_SANTO("Espírito Santo","ES"),
	GOIAS("Goiás","GO"),
	MARANHAO("Maranhão","MA"),
	MATO_GROSSO("Mato Grosso","MT"),
	MATO_GROSSO_DO_SUL("Mato Grosso do Sul","MS"),
	MINAS_GERAIS("Minas Gerais","MG"),
	PARA("Pará","PA"),
	PARAIBA("Paraíba","PB"),
	PARANA("Paraná","PR"),
	PERNANBUCO("Pernambuco","PE"),
	PIAUI("Piauí","PI"),
	RORAIMA("Roraima","RR"),
	RONDONIA("Rondônia","RO"),
	RIO_DE_JANEIRO("Rio de Janeiro","RJ"),
	RIO_GRANDE_DO_NORTE("Rio Grande do Norte","RN"),
	RIO_GRANDE_DO_SUL("Rio Grande do Sul","RS"),
	SANTA_CATARINA("Santa Catarina","SC"),
	SAO_PAULO("São Paulo","SP"),
	SERGIPE("Sergipe","SE"),
	TOCANTINS("Tocantins","TO");
	
	private String label;
	private String sigla;
	
	private Estado(String label, String sigla) {
		this.label = label;
		this.sigla = sigla;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

}
