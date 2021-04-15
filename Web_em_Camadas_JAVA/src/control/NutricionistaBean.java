package control;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import dao.NutricionistaDAO;
import dao.FabricaConexao;
import model.Nutricionista;
import util.JSFUtil;


@ManagedBean
@ViewScoped
public class NutricionistaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	public NutricionistaBean() {
		
	}
	
	private Nutricionista nutricionista;
	private List<Nutricionista> listaNutricionistas;
	private ListDataModel<Nutricionista> listaModelnutricionistas;
	private List<Nutricionista> listaFiltradaModelNutricionistas;

	public Nutricionista getNutricionista() {
		return nutricionista;
	}

	public void setNutricionista(Nutricionista nutricionista) {
	this.nutricionista = nutricionista;
	}

	public ListDataModel<Nutricionista> getListaModelnutricionistas() {
		return listaModelnutricionistas;
	}

	public void setListaModelnutricionistas(ListDataModel<Nutricionista> listaModelnutricionistas) {
		this.listaModelnutricionistas = listaModelnutricionistas;
	}
	
	public List<Nutricionista> getListaFiltradaModelNutricionistas() {
		return listaFiltradaModelNutricionistas;
	}

	public void setListaFiltradaModelNutricionistas(List<Nutricionista> listaFiltradaModelNutricionistas) {
		this.listaFiltradaModelNutricionistas = listaFiltradaModelNutricionistas;
	}

	public void PrepararNovo() {
		this.nutricionista = new Nutricionista();
	}
	
	public void Insert() {
		try {
			FabricaConexao fabrica = new FabricaConexao();
			Connection conexao = fabrica.fazerConexao();
			
			NutricionistaDAO dao = new NutricionistaDAO(conexao);
			
			dao.Inserir(this.nutricionista);
					
			this.nutricionista = new Nutricionista();
			this.listaNutricionistas = dao.listarTodos();
			this.listaModelnutricionistas = new ListDataModel<>(this.listaNutricionistas);
			
			JSFUtil.adicionarMensagemSucesso("Nutricionista cadastrado com sucesso!");
		}
		catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro ao tentar cadastrar um Nutricionista" + e.getMessage());
		}
	}
	
	public void PrepararDelete() 
	{
		this.nutricionista = this.listaModelnutricionistas.getRowData();
	}
	
	public void Delete() {
		try {
			FabricaConexao fabrica = new FabricaConexao();
			Connection conexao = fabrica.fazerConexao();
			
			NutricionistaDAO dao = new NutricionistaDAO(conexao);
			
			dao.Excluir(this.nutricionista.getId());
					
			this.nutricionista = new Nutricionista();			
			this.listaNutricionistas = dao.listarTodos();
			this.listaModelnutricionistas = new ListDataModel<>(this.listaNutricionistas);
			
			JSFUtil.adicionarMensagemSucesso("Nutricionista deletada com sucesso!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void PrepararUpdate() 
	{
		this.nutricionista = this.listaModelnutricionistas.getRowData();
	}
	
	public void Update() {
		try {
			FabricaConexao fabrica = new FabricaConexao();
			Connection conexao = fabrica.fazerConexao();
			
			NutricionistaDAO dao = new NutricionistaDAO(conexao);
			
			dao.Atualizar(this.nutricionista);
					
			this.nutricionista = new Nutricionista();			
			this.listaNutricionistas = dao.listarTodos();
			this.listaModelnutricionistas = new ListDataModel<>(this.listaNutricionistas);
			
			JSFUtil.adicionarMensagemSucesso("Nutricionista atualizado com sucesso!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@PostConstruct
	public void start() {
		try {
			FabricaConexao fab = new FabricaConexao();
			Connection con = fab.fazerConexao();
			
			NutricionistaDAO dao = new NutricionistaDAO(con);
			
			this.listaNutricionistas = dao.listarTodos();
			this.listaModelnutricionistas = new ListDataModel<>(this.listaNutricionistas);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
