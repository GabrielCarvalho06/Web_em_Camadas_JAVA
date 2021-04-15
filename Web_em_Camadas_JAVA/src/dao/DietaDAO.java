package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Dieta;

public class DietaDAO implements DietaInDAO {

	private Connection conexao;
	
	public DietaDAO(Connection _conexao) {
		this.conexao = _conexao;
	}
	
	@Override
	public void Inserir(Dieta _objeto) throws SQLException {
		String SQL = "INSERT INTO dietas (refeicao_1, refeicao_2, refeicao_3, refeicao_4, refeicao_5) VALUES (?, ?, ?, ?, ?) ";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getRefeicao_1());
		ps.setString(2, _objeto.getRefeicao_2());
		ps.setString(3, _objeto.getRefeicao_3());
		ps.setString(4, _objeto.getRefeicao_4());
		ps.setString(5, _objeto.getRefeicao_5());
		ps.execute();
	}

	@Override
	public List<Dieta> listarTodos() throws SQLException {
		List<Dieta> dietas = new ArrayList<Dieta>();
		ResultSet rs = null;
		
		String SQL = "SELECT id, refeicao_1, refeicao_2, refeicao_3, refeicao_4, refeicao_5  FROM dietas";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int id = rs.getInt(1);
			String refeicao_1 = rs.getString(2);
			String refeicao_2 = rs.getString(3);
			String refeicao_3 = rs.getString(4);
			String refeicao_4 = rs.getString(5);
			String refeicao_5 = rs.getString(6);
			
			Dieta p = new Dieta(id, refeicao_1, refeicao_2, refeicao_3, refeicao_4, refeicao_5);
			
			dietas.add(p);
		}
		
		return dietas;
	}

	@Override
	public Boolean Excluir(int _id) throws SQLException {
		String SQL = "DELETE FROM dietas WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
				
		return ps.execute();
	}

	@Override
	public Boolean Atualizar(Dieta _objeto) throws SQLException {
		String SQL = "UPDATE dietas SET refeicao_1 = ?, refeicao_2 = ?, refeicao_3 = ?, refeicao_4 = ?, refeicao_5 = ? WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getRefeicao_1());
		ps.setString(2, _objeto.getRefeicao_2());
		ps.setString(3, _objeto.getRefeicao_3());
		ps.setString(4, _objeto.getRefeicao_4());
		ps.setString(5, _objeto.getRefeicao_5());
		ps.setInt(6, _objeto.getId());
				
		return ps.execute();
	}

	@Override
	public Dieta buscarPorId(int _id) throws SQLException {
ResultSet rs = null;
		
		String SQL = "SELECT id, nome, email FROM dieta WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
		
		rs = ps.executeQuery();
		
		if (rs.next()) {
			
			int id = rs.getInt(1);
			String refeicao_1 = rs.getString(2);
			String refeicao_2 = rs.getString(3);
			String refeicao_3 = rs.getString(4);
			String refeicao_4 = rs.getString(5);
			String refeicao_5 = rs.getString(6);
			
			Dieta p = new Dieta(id, refeicao_1, refeicao_2, refeicao_3, refeicao_4, refeicao_5);
			
			return p;
		}
		return null;
	}
	
	public List<Dieta> listarTodosPorClientes(int _idclientes) throws SQLException {
		List<Dieta> dietas = new ArrayList<Dieta>();
		ResultSet rs = null;
		
		String SQL = "SELECT id, refeicao_1, refeicao_2, refeicao_3, refeicao_4, refeicao_5 FROM dietas WHERE cliente_id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _idclientes);
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int id = rs.getInt(1);
			String refeicao_1 = rs.getString(2);
			String refeicao_2 = rs.getString(3);
			String refeicao_3 = rs.getString(4);
			String refeicao_4 = rs.getString(5);
			String refeicao_5 = rs.getString(6);
			
			Dieta p = new Dieta(id, refeicao_1, refeicao_2, refeicao_3, refeicao_4, refeicao_5);
			
			dietas.add(p);
		}
		return dietas;
	}
}

