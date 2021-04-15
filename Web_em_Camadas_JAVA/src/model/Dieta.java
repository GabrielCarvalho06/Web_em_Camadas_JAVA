package model;

import java.io.Serializable;

public class Dieta implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String refeicao_1;
	private String refeicao_2;
	private String refeicao_3;
	private String refeicao_4;
	private String refeicao_5;
	
	public Dieta () {}
	
	public Dieta(int id, String refeicao_1, String refeicao_2, String refeicao_3, String refeicao_4,
			String refeicao_5) {
		super();
		this.id = id;
		this.refeicao_1 = refeicao_1;
		this.refeicao_2 = refeicao_2;
		this.refeicao_3 = refeicao_3;
		this.refeicao_4 = refeicao_4;
		this.refeicao_5 = refeicao_5;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRefeicao_1() {
		return refeicao_1;
	}

	public void setRefeicao_1(String refeicao_1) {
		this.refeicao_1 = refeicao_1;
	}

	public String getRefeicao_2() {
		return refeicao_2;
	}

	public void setRefeicao_2(String refeicao_2) {
		this.refeicao_2 = refeicao_2;
	}

	public String getRefeicao_3() {
		return refeicao_3;
	}

	public void setRefeicao_3(String refeicao_3) {
		this.refeicao_3 = refeicao_3;
	}

	public String getRefeicao_4() {
		return refeicao_4;
	}

	public void setRefeicao_4(String refeicao_4) {
		this.refeicao_4 = refeicao_4;
	}

	public String getRefeicao_5() {
		return refeicao_5;
	}

	public void setRefeicao_5(String refeicao_5) {
		this.refeicao_5 = refeicao_5;
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
		Dieta other = (Dieta) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Dieta [id=" + id + ", refeicao_1=" + refeicao_1 + ", refeicao_2=" + refeicao_2 + ", refeicao_3="
				+ refeicao_3 + ", refeicao_4=" + refeicao_4 + ", refeicao_5=" + refeicao_5 + "]";
	}
}

