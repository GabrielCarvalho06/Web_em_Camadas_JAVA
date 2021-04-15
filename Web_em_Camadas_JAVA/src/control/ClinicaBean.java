package control;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import dao.ClinicaDAO;
import dao.FabricaConexao;
import model.Clinica;
import util.JSFUtil;


@ManagedBean
@ViewScoped
public class ClinicaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	public ClinicaBean() {
		
	}
	
	private Clinica clinica;
	private List<Clinica> listaClinicas;
	private ListDataModel<Clinica> listaModelclinicas;
	private List<Clinica> listaFiltradaModelClinicas;

	public Clinica getClinica() {
		return clinica;
	}

	public void setClinica(Clinica clinica) {
	this.clinica = clinica;
	}
	
	public ListDataModel<Clinica> getListaModelclinicas() {
		return listaModelclinicas;
	}

	public void setListaModelclinicas(ListDataModel<Clinica> listaModelclinicas) {
		this.listaModelclinicas = listaModelclinicas;
	}
	
	public List<Clinica> getListaFiltradaModelClinicas() {
		return listaFiltradaModelClinicas;
	}

	public void setListaFiltradaModelClinicas(List<Clinica> listaFiltradaModelClinicas) {
		this.listaFiltradaModelClinicas = listaFiltradaModelClinicas;
	}

	public void PrepararNovo() {
		this.clinica = new Clinica();
	}
	
	public void Insert() {
		try {
			FabricaConexao fabrica = new FabricaConexao();
			Connection conexao = fabrica.fazerConexao();
			
			ClinicaDAO dao = new ClinicaDAO(conexao);
			
			dao.Inserir(this.clinica);
					
			this.clinica = new Clinica();
			this.listaClinicas = dao.listarTodos();
			this.listaModelclinicas = new ListDataModel<>(this.listaClinicas);
			
			JSFUtil.adicionarMensagemSucesso("Clinica cadastrada com sucesso!");
		}
		catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro ao tentar cadastrar uma clinica" + e.getMessage());
		}
	}
	
	public void PrepararDelete() 
	{
		this.clinica = new Clinica();
		this.clinica = this.listaModelclinicas.getRowData();
	}
	
	public void Delete() {
		try {
			FabricaConexao fabrica = new FabricaConexao();
			Connection conexao = fabrica.fazerConexao();
			
			ClinicaDAO dao = new ClinicaDAO(conexao);
			
			dao.Excluir(this.clinica.getId());
					
			this.clinica = new Clinica();
			this.listaClinicas = dao.listarTodos();
			this.listaModelclinicas = new ListDataModel<>(this.listaClinicas);
			
			JSFUtil.adicionarMensagemSucesso("Clinica deletada com sucesso!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void PrepararUpdate() 
	{
		this.clinica = new Clinica();
		this.clinica = this.listaModelclinicas.getRowData();
	}
	
	public void Update() {
		try {
			FabricaConexao fabrica = new FabricaConexao();
			Connection conexao = fabrica.fazerConexao();
			
			ClinicaDAO dao = new ClinicaDAO(conexao);
			
			dao.Atualizar(this.clinica);
					
			this.clinica = new Clinica();
			
			this.listaClinicas = dao.listarTodos();
			this.listaModelclinicas = new ListDataModel<>(this.listaClinicas);
			
			JSFUtil.adicionarMensagemSucesso("Clinica atualizado com sucesso!");
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
			
			ClinicaDAO dao = new ClinicaDAO(con);
			
			this.listaClinicas = dao.listarTodos();
			this.listaModelclinicas = new ListDataModel<>(this.listaClinicas);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
