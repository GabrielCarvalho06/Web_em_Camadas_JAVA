package dao;

import java.sql.SQLException;
import java.util.List;

import model.Clinica;

public interface ClinicaInDAO {

	void Inserir(Clinica _objeto) throws SQLException;
	
	List<Clinica> listarTodos() throws SQLException;
	
	Boolean Excluir(int _id) throws SQLException;
	
	Boolean Atualizar(Clinica _objeto) throws SQLException;
	
	Clinica buscarPorId(int _id) throws SQLException;
}
