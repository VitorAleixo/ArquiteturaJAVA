package com.up.clinicavet.model;
import java.util.List;

public class Especie 
{
	//Strings Declaradas
	private int ID;
	private String Nome;
	private String Descricao;
	private Tipo_Animal TipoAnimal;
	
	//CONSTRUTORES
	public Especie() {}
	
	public Especie(int id, String nome, String descricao, Tipo_Animal tipoanimal)
	{
		super();
		this.ID = id;
		this.Nome = nome;
		this.Descricao = descricao;
		this.TipoAnimal = tipoanimal;
	}
	
	public Especie(int id, String nome) 
	{
		super();
		this.ID = id;
		this.Nome = nome;
		
	}
	
	//GETTERS E SETTERS
	public int getID() {
		return ID;
	}
	

	public void setID(int iD) {
		ID = iD;
	}
	
	
	public String getNome() {
		return Nome;
	}
	
	
	public void setNome(String nome) throws Exception{
		if (nome == null || nome.isEmpty())
		{
			throw new Exception("Especie deve ter um nome!");
		}
		
		else if (nome.length() > 50)
		{
			throw new Exception("Nome da especie nao deve exceder 50 CARACTERES!!");
		}
		
		else 
		{
			Nome = nome;
		}
	}
	
	
	public String getDescricao() {
		return Descricao;
	}
	
	
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	
	public Tipo_Animal getTipoAnimal() {
		return TipoAnimal;
	}


	public void setTipoAnimal(Tipo_Animal tipoanimal) 
	{
		TipoAnimal = tipoanimal;
	}
	
}
