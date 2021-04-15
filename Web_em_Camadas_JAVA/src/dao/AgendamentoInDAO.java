package dao;

import java.sql.SQLException;
import java.util.List;

import model.Agendamento;

public interface AgendamentoInDAO {

	void Inserir(Agendamento _objeto) throws SQLException;
	
	List<Agendamento> listarTodos() throws SQLException;
	
	Boolean Excluir(int _id) throws SQLException;
	
	Boolean Atualizar(Agendamento _objeto) throws SQLException;
	
	Agendamento buscarPorId(int _id) throws SQLException;
}
