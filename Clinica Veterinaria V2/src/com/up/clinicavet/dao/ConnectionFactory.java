package com.up.clinicavet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection getConnection() 
	{
		try 
		{
			//STATIC = PERTENCE A CLASSE NAO A UM OBJETO
			return DriverManager.getConnection(
				"jdbc:hsqldb:hsql://localhost/clinicaveterinariadb","SA",""); //Conecta com o BD
		}
		catch(SQLException e) 
		{
			throw new RuntimeException(e); //Joga erro na tela caso nao de certo a conexão
			//MAS JAMAIS FAZER ISSO! Fazer um LOG, pois se da erro e um erro grave!
		}
		
	}
}
