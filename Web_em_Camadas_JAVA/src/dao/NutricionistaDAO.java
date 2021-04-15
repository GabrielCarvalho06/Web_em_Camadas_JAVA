package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Nutricionista;

public class NutricionistaDAO implements NutricionistaInDAO {

	private Connection conexao;
	
	public NutricionistaDAO(Connection _conexao) {
		this.conexao = _conexao;
	}
	
	@Override
	public void Inserir(Nutricionista _objeto) throws SQLException {
		String SQL = "INSERT INTO nutricionistas (nome, idade, sexo, cpf, crn, email) VALUES (?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getNome());
		ps.setInt(2, _objeto.getIdade());
		ps.setString(3, _objeto.getSexo());
		ps.setString(4, _objeto.getCpf());
		ps.setString(5, _objeto.getCrn());
		ps.setString(6,  _objeto.getEmail());
		ps.execute();

	}

	@Override
	public List<Nutricionista> listarTodos() throws SQLException {
		List<Nutricionista> nutricionista = new ArrayList<Nutricionista>();
		ResultSet rs = null;
		
		String SQL = "SELECT id, nome, idade, sexo, cpf, crn, email FROM nutricionistas";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int id = rs.getInt(1);
			String nome = rs.getString(2);
			int idade = rs.getInt(3);
			String sexo = rs.getString(4);
			String cpf = rs.getString(5);
			String crn = rs.getString(6);
			String email = rs.getString(7);
			
			Nutricionista p = new Nutricionista(id, nome, idade, sexo, cpf, crn, email);
			
			nutricionista.add(p);
		}
		
		return nutricionista;
	}

	@Override
	public Boolean Excluir(int _id) throws SQLException {
String SQL = "DELETE FROM nutricionistas WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
				
		return ps.execute();
	}

	@Override
	public Boolean Atualizar(Nutricionista _objeto) throws SQLException {
		String SQL = "UPDATE nutricionistas SET nome = ?, idade = ?, sexo = ?, cpf = ?, crn = ?, email = ? WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getNome());
		ps.setInt(2, _objeto.getIdade());
		ps.setString(3, _objeto.getSexo());
		ps.setString(4, _objeto.getCpf());
		ps.setString(5, _objeto.getCrn());
		ps.setString(6,  _objeto.getEmail());
		ps.setInt(7, _objeto.getId());

		return ps.execute();
	}

	@Override
	public Nutricionista buscarPorId(int _id) throws SQLException {
		ResultSet rs = null;
		
		String SQL = "SELECT id, nome, email FROM nutricionistas WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
		
		rs = ps.executeQuery();
		
		if (rs.next()) {
			
			int id = rs.getInt(1);
			String nome = rs.getString(2);
			int idade = rs.getInt(3);
			String sexo = rs.getString(4);
			String cpf = rs.getString(5);
			String crn = rs.getString(6);
			String email = rs.getString(7);

			Nutricionista p = new Nutricionista(id, nome, idade, sexo, cpf, crn, email);
			
			return p;
		}
		return null;
	}

}
