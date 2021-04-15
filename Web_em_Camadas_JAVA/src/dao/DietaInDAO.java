package dao;

import java.sql.SQLException;
import java.util.List;

import model.Dieta;

public interface DietaInDAO {

	void Inserir(Dieta _objeto) throws SQLException;
	
	List<Dieta> listarTodos() throws SQLException;
	
	Boolean Excluir(int _id) throws SQLException;
	
	Boolean Atualizar(Dieta _objeto) throws SQLException;
	
	Dieta buscarPorId(int _id) throws SQLException;
}
