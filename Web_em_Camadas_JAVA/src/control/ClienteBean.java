package control;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import org.primefaces.model.chart.PieChartModel;

import dao.ClienteDAO;
import dao.FabricaConexao;
import model.Cliente;
import util.JSFUtil;


@ManagedBean
@ViewScoped
public class ClienteBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public ClienteBean() {
		
	}
	private int infancia = 0;
	private int adolescencia = 0;
	private int adulto = 0;
	private int idoso = 0;
	private Cliente cliente;
	private List<Cliente> listaClientes;
	private ListDataModel<Cliente> listaModelclientes;
	private List<Cliente> listaFilstradaModelClientes;
    private PieChartModel pieModel2;   
	public Cliente getCliente() {
		return cliente;
	}

	public PieChartModel getPieModel2() {
		return pieModel2;
	}

	public void setCliente(Cliente cliente) {
	this.cliente = cliente;
	}
	
	public ListDataModel<Cliente> getListaModelclientes() {
		return listaModelclientes;
	}

	public void setListaModelclientes(ListDataModel<Cliente> listaModelclientes) {
		this.listaModelclientes = listaModelclientes;
	}

	public List<Cliente> getListaFilstradaModelClientes() {
		return listaFilstradaModelClientes;
	}

	public void setListaFilstradaModelClientes(List<Cliente> listaFilstradaModelClientes) {
		this.listaFilstradaModelClientes = listaFilstradaModelClientes;
	}

	public void PrepararNovo() {
		this.cliente = new Cliente();
	}
	
	public void Insert() {
		try {
			FabricaConexao fabrica = new FabricaConexao();
			Connection conexao = fabrica.fazerConexao();
			
			ClienteDAO dao = new ClienteDAO(conexao);
			
			dao.Inserir(this.cliente);
					
			this.cliente = new Cliente();
			this.listaClientes = dao.listarTodos();
			this.listaModelclientes = new ListDataModel<>(this.listaClientes);
			
			JSFUtil.adicionarMensagemSucesso("Cliente cadastrado com sucesso!");
		}
		catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro("Erro ao tentar cadastrar um cliente" + e.getMessage());
		}
	}
	
	public void PrepararDelete() 
	{	
		this.cliente = this.listaModelclientes.getRowData();
	}
	
	public void Delete() {
		try {
			FabricaConexao fabrica = new FabricaConexao();
			Connection conexao = fabrica.fazerConexao();
			
			ClienteDAO dao = new ClienteDAO(conexao);
			
			dao.Excluir(this.cliente.getIdCliente());
					
			this.cliente = new Cliente();
			this.listaClientes = dao.listarTodos();
			this.listaModelclientes = new ListDataModel<>(this.listaClientes);
			
			JSFUtil.adicionarMensagemSucesso("Cliente deletado com sucesso!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void PrepararUpdate() 
	{	
		this.cliente = this.listaModelclientes.getRowData();
	}
	
	public void Update() {
		try {
			FabricaConexao fabrica = new FabricaConexao();
			Connection conexao = fabrica.fazerConexao();
			
			ClienteDAO dao = new ClienteDAO(conexao);
			
			dao.Atualizar(this.cliente);
					
			this.cliente = new Cliente();			
			this.listaClientes = dao.listarTodos();
			this.listaModelclientes = new ListDataModel<>(this.listaClientes);
			
			JSFUtil.adicionarMensagemSucesso("Cliente atualizado com sucesso!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
    private void criarmodelografico() {
        pieModel2 = new PieChartModel();
 
        pieModel2.set("Infantil", infancia);
        pieModel2.set("Adolescentes", adolescencia);
        pieModel2.set("Adulto", adulto);
        pieModel2.set("Idoso", idoso);
        
        pieModel2.setTitle("Gráfico de idade entre os clientes");
        pieModel2.setLegendPosition("e");
        pieModel2.setFill(true);
        pieModel2.setShowDataLabels(true);
        pieModel2.setDiameter(300);
        pieModel2.setShadow(true);
    }
	@PostConstruct
	public void start() {
		try {
			FabricaConexao fab = new FabricaConexao();
			Connection con = fab.fazerConexao();			
			ClienteDAO dao = new ClienteDAO(con);

			
			this.listaClientes = dao.listarTodos();
			this.listaModelclientes = new ListDataModel<>(this.listaClientes);
			
			for (Cliente cliente : listaClientes) {
				if (cliente.getIdade() <= 11) {
					infancia ++;
				}
				else if (cliente.getIdade() >= 12 && cliente.getIdade() <=17) {
					adolescencia ++;
				}
				else if (cliente.getIdade() >=18 && cliente.getIdade() <=59) {
					adulto ++;
				}
				else {
					idoso ++;
				}
			}
			criarmodelografico();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
