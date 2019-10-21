package br.edu.ifg.model;

public class Pessoa {
	
	private String nomePessoa;
	private String email;
	private String telefone;
	
	
	public String getNomePessoa() {
		return nomePessoa;
	}
	public String getEmail() {
		return email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Nome: " + nomePessoa + "\nemail: "+ email + "\ntelefone: " + telefone;
	}
	
	
}
