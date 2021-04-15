package dao;

import java.sql.SQLException;
import java.util.List;

import model.Cliente;

public interface ClienteInDAO {

	void Inserir(Cliente _objeto) throws SQLException;
	
	List<Cliente> listarTodos() throws SQLException;
	
	Boolean Excluir(int _idclientes) throws SQLException;
	
	Boolean Atualizar(Cliente _objeto) throws SQLException;
	
	Cliente buscarPorId(int _idclientes) throws SQLException;
}
