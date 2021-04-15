package model;

import java.io.Serializable;

public class Nutricionista implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nome;
	private int idade;
	private String sexo;
	private String cpf;
	private String crn;
	private String email;
	
	public Nutricionista() {}
	
	public Nutricionista(int id, String nome, int idade, String sexo, String cpf, String crn, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
		this.cpf = cpf;
		this.crn = crn;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getCrn() {
		return crn;
	}

	public void setCrn(String crn) {
		this.crn = crn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Nutricionista other = (Nutricionista) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Nutricionista [id=" + id + ", nome=" + nome + ", idade=" + idade + ", sexo=" + sexo + ", cpf=" + cpf
				+ ", crn=" + crn + ", email=" + email + "]";
	}	
}
