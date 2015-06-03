package escola.musica.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import escola.musica.modelo.Cidade;
import escola.musica.modelo.Estado;
import escola.musica.servico.CidadeServico;
import escola.musica.util.Mensagem;

@Controller("cidadeBean")
@Scope
public class CidadeBean implements Serializable {

	private static final long serialVersionUID = -8077768006424832717L;

	private Cidade cidade = new Cidade();
	private List<Cidade> cidades;
	private Cidade cidadeSelecionada;
	
	@Autowired
	private CidadeServico cidadeServico;
	
	public void iniciarBean() {
		consultar();
	}

	public void salvar() {
		cidadeServico.salvar(cidade);
		Mensagem.mensagemInformacao("Cidade cadastrada com sucesso!");
		cidade = new Cidade();
		cidadeSelecionada = null;
		consultar();
		// RequestContext.getCurrentInstance().execute("PF('cadastroCidadeDialog').hide()");
	}

	public void cancelar() {
		cidade = new Cidade();
		cidadeSelecionada = null;
	}
	
	public void excluir(){
		cidadeServico.excluir(cidadeSelecionada);
		cidadeSelecionada = null;
		consultar();
	}
	
	public void onRowEdit(RowEditEvent event){
		cidade = (Cidade) event.getObject();
		salvar();
	}
	
	public void onCellEdit(CellEditEvent event){
		DataTable table = (DataTable) event.getSource();
		cidade = (Cidade) table.getRowData();
		salvar();
	}

	public void consultar() {
		cidades = cidadeServico.listarTodas();
	}

	public List<Estado> getEstados() {
		return Arrays.asList(Estado.values());
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public Cidade getCidadeSelecionada() {
		return cidadeSelecionada;
	}

	public void setCidadeSelecionada(Cidade cidadeSelecionada) {
		this.cidadeSelecionada = cidadeSelecionada;
	}

}
