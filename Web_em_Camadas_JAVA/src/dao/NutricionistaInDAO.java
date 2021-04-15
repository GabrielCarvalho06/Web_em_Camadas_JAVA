package dao;

import java.sql.SQLException;
import java.util.List;

import model.Nutricionista;

public interface NutricionistaInDAO {

	void Inserir(Nutricionista _objeto) throws SQLException;
	
	List<Nutricionista> listarTodos() throws SQLException;
	
	Boolean Excluir(int _id) throws SQLException;
	
	Boolean Atualizar(Nutricionista _objeto) throws SQLException;
	
	Nutricionista buscarPorId(int _id) throws SQLException;
}
