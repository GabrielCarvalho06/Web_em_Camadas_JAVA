package model;

import java.io.Serializable;
import java.util.List;

public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int idclientes;
	private String nome;
	private int idade;
	private String sexo;
	private String cpf;
	private String email;
	private String telefone;
	private List<Dieta> dietas;
	
	public Cliente() {}
	
	public Cliente(int idclientes, String nome, int idade, String sexo, String cpf, String email, String telefone, List<Dieta>dietas) {
		super();
		this.idclientes = idclientes;
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.dietas = dietas;
	}

	public int getIdCliente() {
		return idclientes;
	}
	public void setIdCliente(int idclientes) {
		this.idclientes = idclientes;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public List<Dieta> getDietas() {
		return dietas;
	}

	public void setDieta(List<Dieta> dietas) {
		this.dietas = dietas;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idclientes;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (idclientes != other.idclientes)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [idclientes=" + idclientes + ", nome=" + nome + ", idade=" + idade + ", sexo=" + sexo + ", cpf="
				+ cpf + ", email=" + email + ", telefone=" + telefone + ", dietas=" + dietas + "]";
	}	
}
