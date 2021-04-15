package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import model.Dieta;

public class ClienteDAO implements ClienteInDAO {
	
	private Connection conexao;
	
	public ClienteDAO(Connection _conexao) {
		this.conexao = _conexao;
	}
	
	@Override
	public void Inserir(Cliente _objeto) throws SQLException {
		String SQL = "INSERT INTO clientes (nome, idade, sexo, cpf, email, telefone) VALUES (?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getNome());
		ps.setInt(2, _objeto.getIdade());
		ps.setString(3, _objeto.getSexo());
		ps.setString(4, _objeto.getCpf());
		ps.setString(5,  _objeto.getEmail());
		ps.setString(6, _objeto.getTelefone());
		ps.execute();
	}

	@Override
	public List<Cliente> listarTodos() throws SQLException {
		List<Cliente> clientes = new ArrayList<Cliente>();
		ResultSet rs = null;
		
		String SQL = "SELECT idclientes, nome, idade, sexo, cpf, email, telefone FROM clientes";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int id = rs.getInt(1);
			String nome = rs.getString(2);
			int idade = rs.getInt(3);
			String sexo = rs.getString(4);
			String cpf = rs.getString(5);
			String email = rs.getString(6);
			String telefone = rs.getString(7);
			
			DietaDAO daoDieta = new DietaDAO(this.conexao);
			
			List<Dieta> dietas = daoDieta.listarTodosPorClientes(id);
			
			Cliente p = new Cliente(id, nome, idade, sexo, cpf, email, telefone, dietas);
			
			clientes.add(p);
		}
		
		return clientes;
	}

	@Override
	public Boolean Excluir(int _idcliente) throws SQLException {
		String SQL = "DELETE FROM clientes WHERE idclientes = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _idcliente);
				
		return ps.execute();
	}

	@Override
	public Boolean Atualizar(Cliente _objeto) throws SQLException {
		String SQL = "UPDATE clientes SET nome = ?, idade = ?, sexo = ?, cpf = ?, email = ?, telefone = ? WHERE idclientes = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getNome());
		ps.setInt(2, _objeto.getIdade());
		ps.setString(3, _objeto.getSexo());
		ps.setString(4, _objeto.getCpf());
		ps.setString(5,  _objeto.getEmail());
		ps.setString(6, _objeto.getTelefone());
		ps.setInt(7, _objeto.getIdCliente());
				
		return ps.execute();
	}

	@Override
	public Cliente buscarPorId(int _idcliente) throws SQLException {
		ResultSet rs = null;
		
		String SQL = "SELECT idclientes, nome, email FROM clientes WHERE idclientes = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _idcliente);
		
		rs = ps.executeQuery();
		
		if (rs.next()) {
			
			int id = rs.getInt(1);
			String nome = rs.getString(2);
			int idade = rs.getInt(3);
			String sexo = rs.getString(4);
			String cpf = rs.getString(5);
			String email = rs.getString(6);
			String telefone = rs.getString(7);
			
			DietaDAO daoDieta = new DietaDAO(this.conexao);
			
			List<Dieta> dietas = daoDieta.listarTodosPorClientes(id);
			
			Cliente p = new Cliente(id, nome, idade, sexo, cpf, email, telefone, dietas);
			
			return p;
		}
		return null;
		
	}
	
}
