package com.up.clinicavet.model;
import java.sql.Date;

public class Animal 
{
	//Strings Declaradas
		private int ID;
		private String Nome;
		private Date Nascimento ;
		private Especie Especie;
		
		public Animal() {}
		
		public Animal(int iD, String nome, Date nascimento, Especie especie) 
		{
			super();
			ID = iD;
			Nome = nome;
			Nascimento = nascimento;
			Especie = especie;
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
				throw new Exception("Animal deve ter um nome!");
			}
			
			else if (nome.length() > 50)
			{
				throw new Exception("Nome do animal nao deve exceder 50 CARACTERES!!");
			}
			
			else 
			{
				Nome = nome;
			}
		}
		
		
		public Date getNascimento() {
			return Nascimento;
		}
		
		
		public void setNascimento(Date nascimento) throws Exception {
			String datanascimento = nascimento.toString();
			if (datanascimento.length() > 10)
			{
				throw new Exception("Insira uma data valida!");
			}
			else {
			Nascimento = nascimento;
			}
		}
		
		
		public Especie getEspecie() {
			return Especie;
		}


		public void setEspecie(Especie especie) {
			Especie = especie;
		}
		
		
}
