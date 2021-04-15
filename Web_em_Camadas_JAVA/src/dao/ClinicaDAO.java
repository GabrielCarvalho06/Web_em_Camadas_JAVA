package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Clinica;

public class ClinicaDAO implements ClinicaInDAO {
	
private Connection conexao;
	
	public ClinicaDAO(Connection _conexao) {
		this.conexao = _conexao;
	}

	@Override
	public void Inserir(Clinica _objeto) throws SQLException {
		String SQL = "INSERT INTO clinicas (nome, endereco, telefone) VALUES (?, ?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getNome());
		ps.setString(2, _objeto.getEndereco());	
		ps.setString(3, _objeto.getTelefone());
		ps.execute();
	}

	@Override
	public List<Clinica> listarTodos() throws SQLException {
		List<Clinica> clinica = new ArrayList<Clinica>();
		ResultSet rs = null;
		
		String SQL = "SELECT id, nome, endereco, telefone FROM clinicas";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int id = rs.getInt(1);
			String nome = rs.getString(2);
			String endereco = rs.getString(3);
			String telefone = rs.getString(4);
			
			Clinica p = new Clinica(id, nome, endereco, telefone);
			
			clinica.add(p);
		}
		
		return clinica;
	}

	@Override
	public Boolean Excluir(int _id) throws SQLException {
		String SQL = "DELETE FROM clinicas WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
				
		return ps.execute();
	}

	@Override
	public Boolean Atualizar(Clinica _objeto) throws SQLException {
		String SQL = "UPDATE clinicas SET nome = ?, endereco = ?, telefone = ? WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getNome());
		ps.setString(2, _objeto.getEndereco());	
		ps.setString(3, _objeto.getTelefone());
		ps.setInt(4, _objeto.getId());
		
		return ps.execute();
	}

	@Override
	public Clinica buscarPorId(int _id) throws SQLException {
		ResultSet rs = null;
		
		String SQL = "SELECT id, nome, endereco, telefone FROM clinicas WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
		
		rs = ps.executeQuery();
		
		if (rs.next()) {
			
			int id = rs.getInt(1);
			String nome = rs.getString(2);
			String endereco = rs.getString(3);
			String telefone = rs.getString(4);
			
			Clinica p = new Clinica(id, nome, endereco, telefone);
			
			return p;
		}
		return null;
	}

}
