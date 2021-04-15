package control;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import dao.DietaDAO;
import dao.FabricaConexao;
import model.Dieta;
import util.JSFUtil;


@ManagedBean
@ViewScoped
public class DietaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public DietaBean() {
		
	}
	
	private Dieta dieta;
	private List<Dieta> listaDietas;
	private ListDataModel<Dieta> listaModeldietas;

	public Dieta getDieta() {
		return dieta;
	}

	public void setDieta(Dieta dieta) {
	this.dieta = dieta;
	}

	public List<Dieta> getListaDietas() {
		return listaDietas;
	}

	public void setListaDietas(List<Dieta> listaDietas) {
		this.listaDietas = listaDietas;
	}
	
	public ListDataModel<Dieta> getListaModelDietas() {
		return listaModeldietas;
	}

	public void setListaModeldietas(ListDataModel<Dieta> listaModeldietas) {
		this.listaModeldietas = listaModeldietas;
	}

	public void PrepararNovo() {
		this.dieta = this.listaModeldietas.getRowData();
		this.dieta = new Dieta();
	}
	
	public void Insert() {
		try {
			FabricaConexao fabrica = new FabricaConexao();
			Connection conexao = fabrica.fazerConexao();
			
			DietaDAO dao = new DietaDAO(conexao);
			
			dao.Inserir(this.dieta);
					
			this.dieta = new Dieta();
			
			this.listaDietas = dao.listarTodos();
			
			JSFUtil.adicionarMensagemSucesso("Dieta cadastrada com sucesso!");
		}
		catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro ao tentar cadastrar uma Dieta" + e.getMessage());
		}
	}
	
	public void PrepararDelete() 
	{
		this.dieta = new Dieta();
	}
	
	public void Delete() {
		try {
			FabricaConexao fabrica = new FabricaConexao();
			Connection conexao = fabrica.fazerConexao();
			
			DietaDAO dao = new DietaDAO(conexao);
			
			dao.Excluir(this.dieta.getId());
					
			this.dieta = new Dieta();
			
			this.listaDietas = dao.listarTodos();
			this.listaModeldietas = new ListDataModel<>(this.listaDietas);
			
			JSFUtil.adicionarMensagemSucesso("Dieta deletada com sucesso!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void PrepararUpdate() 
	{
		this.dieta = new Dieta();
	}
	
	public void Update() {
		try {
			FabricaConexao fabrica = new FabricaConexao();
			Connection conexao = fabrica.fazerConexao();
			
			DietaDAO dao = new DietaDAO(conexao);
			
			dao.Atualizar(this.dieta);
					
			this.dieta = new Dieta();
			
			this.listaDietas = dao.listarTodos();
			this.listaModeldietas = new ListDataModel<>(this.listaDietas);
			
			JSFUtil.adicionarMensagemSucesso("Dieta atualizado com sucesso!");
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
			
			DietaDAO dao = new DietaDAO(con);
			
			this.listaDietas = dao.listarTodos();
			this.listaModeldietas = new ListDataModel<>(this.listaDietas);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
