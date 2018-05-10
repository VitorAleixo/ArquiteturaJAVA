package com.up.clinicavet.model;

public class Tipo_Animal
{
	//Strings Declaradas
	public String Acronimo;
	public String Nome;
	public String Descricao;
	
	//CONSTRUTORES
	public Tipo_Animal(){}
	
	public Tipo_Animal(String acronimo, String nome, String descricao) {
		super();
		Acronimo = acronimo;
		Nome = nome;
		Descricao = descricao;
	}

	
	//GETTERS E SETTERS
	public String getAcronimo() {
		return Acronimo;
	}
	
	
	public void setAcronimo(String acronimo) throws Exception{
		if(acronimo == null || acronimo.isEmpty())
		{
			throw new Exception("Acronimo não pode ser vazio!");
		}
		else if(acronimo.length() > 3)
		{
			throw new Exception("Acronimo não pode exceder 3 CARACTERES!!");
		}
		else 
		{
			Acronimo = acronimo;
		}
	}
	
	
	public String getNome() {
		return Nome;
	}
	
	
	public void setNome(String nome) throws Exception{
		if (nome == null || nome.isEmpty())
		{
			throw new Exception("Nome deve existir!");
		}
		
		else if (nome.length() > 100)
		{
			throw new Exception("Nome nao deve exceder 100 CARACTERES!!");
		}
		
		else 
		{
			Nome = nome;
		}
	}
	
	
	public String getDescricao() {
		return Descricao;
	}
	
	
	public void setDescricao(String descricao) throws Exception {
		if (descricao.length() > 255)
		{
			throw new Exception("Descricao nao deve exceder 255 CARACTERES!!");
		}
		else 
		{
			Descricao = descricao;
		}
	}
	
	
	
}
