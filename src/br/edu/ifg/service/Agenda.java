package br.edu.ifg.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import br.edu.ifg.model.Pessoa;

public class Agenda {

	
	Map<String,ArrayList<Pessoa>> contatos = new HashMap<String, ArrayList<Pessoa>>();
String[] chaves = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","Z","W","Y","Z"};
	
	public Agenda() {
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		for (String chave : chaves) {
			contatos.put(chave, pessoas);
		}
	}
	
	public boolean remover(String nome) {
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		String letra=chaveLetra(nome);
		pessoas = contatos.get(letra);
		
		for(int i=0; i<pessoas.size(); i++){
			Pessoa x = new Pessoa();
			x = pessoas.get(i);
			if(x.getNomePessoa().equals(nome)) {
				System.out.println("nome x:" + x.getNomePessoa());
				contatos.get(letra).remove(i);
				return true;}
		}
		return false;
	};
	
	public void adicionar(Pessoa pessoa) {
		String keyLetra;
		keyLetra=chaveLetra(pessoa.getNomePessoa());

		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas = contatos.get(keyLetra);
		if(pessoas==null) {
			ArrayList<Pessoa> px = new ArrayList<Pessoa>();
			px.add(pessoa);
			contatos.put(keyLetra, px);
		}
		else
			contatos.get(keyLetra).add(pessoa);
	}
	
	public boolean buscar(String nome,Pessoa x) {
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		String letra=chaveLetra(nome);
		pessoas = contatos.get(letra);

		if(pessoas!=null) {
			for(int i=0; i<pessoas.size(); i++){
				x = pessoas.get(i);
				if(x.getNomePessoa().equals(nome))
					return true;
			}
		}
		return false;
	};

	public String chaveLetra(String nome) {
		String primeiraLetra = nome.substring(0, 1);
		primeiraLetra= primeiraLetra.toLowerCase();
		return primeiraLetra;
	}
}
