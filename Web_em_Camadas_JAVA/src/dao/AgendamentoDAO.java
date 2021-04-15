package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Agendamento;

public class AgendamentoDAO implements AgendamentoInDAO {
	
private Connection conexao;
	
	public AgendamentoDAO(Connection _conexao) {
		this.conexao = _conexao;
	}
	
	@Override
	public void Inserir(Agendamento _objeto) throws SQLException {
String SQL = "INSERT INTO agendamento (data, hora) VALUES (?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getData());
		ps.setString(2, _objeto.getHora());
		ps.execute();
	}

	@Override
	public List<Agendamento> listarTodos() throws SQLException {
		List<Agendamento> agendamento = new ArrayList<Agendamento>();
		ResultSet rs = null;
		
		String SQL = "SELECT id, data, hora FROM Agendamento";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int id = rs.getInt(1);
			String data = rs.getString(2);
			String hora = rs.getString(3);
			
			Agendamento p = new Agendamento(id, data, hora);
			
			agendamento.add(p);
		}
		
		return agendamento;
	}

	@Override
	public Boolean Excluir(int _id) throws SQLException {
		String SQL = "DELETE FROM agendamento WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
				
		return ps.execute();
	}

	@Override
	public Boolean Atualizar(Agendamento _objeto) throws SQLException {
		String SQL = "UPDATE agendamento SET data = ?, hora = ?, WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		

		ps.setString(1, _objeto.getData());
		ps.setString(2, _objeto.getHora());
		ps.setInt(3, _objeto.getId());
				
		return ps.execute();
	}

	@Override
	public Agendamento buscarPorId(int _id) throws SQLException {
ResultSet rs = null;
		
		String SQL = "SELECT id, data, hora FROM agendamento WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
		
		rs = ps.executeQuery();
		
		if (rs.next()) {
			
			int id = rs.getInt(1);
			String data = rs.getString(2);
			String hora = rs.getString(3);
			
			Agendamento p = new Agendamento(id, data, hora);
			
			return p;
		}
		return null;
		}
		public List<Agendamento> listarTodosPorClientes(int _idclientes) throws SQLException {
		List<Agendamento> agendamentos = new ArrayList<Agendamento>();
		ResultSet rs = null;
		
		String SQL = "SELECT id, data, hora FROM agendamento WHERE cliente_id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(0, _idclientes);
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int id = rs.getInt(1);
			String data = rs.getString(2);
			String hora = rs.getString(3);
			
			Agendamento p = new Agendamento(id, data, hora);
			
			agendamentos.add(p);
		}
		return agendamentos;
		}
		public List<Agendamento> listarTodosPorNutricionistas(int _id) throws SQLException {
			List<Agendamento> agendamentos = new ArrayList<Agendamento>();
			ResultSet rs = null;
			
			String SQL = "SELECT id, data, hora FROM agendamento WHERE nutricionista_id = ?";
			
			PreparedStatement ps = this.conexao.prepareStatement(SQL);
			
			ps.setInt(0, _id);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				int id = rs.getInt(1);
				String data = rs.getString(2);
				String hora = rs.getString(3);
				
				Agendamento p = new Agendamento(id, data, hora);
				
				agendamentos.add(p);
			}
			return agendamentos;
			}
		public List<Agendamento> listarTodosPorClinicas(int _id) throws SQLException {
			List<Agendamento> agendamentos = new ArrayList<Agendamento>();
			ResultSet rs = null;
			
			String SQL = "SELECT id, data, hora FROM agendamento WHERE clinica_id = ?";
			
			PreparedStatement ps = this.conexao.prepareStatement(SQL);
			
			ps.setInt(0, _id);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				int id = rs.getInt(1);
				String data = rs.getString(2);
				String hora = rs.getString(3);
				
				Agendamento p = new Agendamento(id, data, hora);
				
				agendamentos.add(p);
			}
			return agendamentos;
	}
}
